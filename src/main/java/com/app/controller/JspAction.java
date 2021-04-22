package com.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSONArray;
import com.app.form.HeroRegistForm;
import com.app.model.Hero;
import com.app.repository.HeroRepository;

@Controller
@RequestMapping(value = "/jsp")
public class JspAction {

    /** jsp页面el测试用 */
    public static final String COLUNM_NAME = "NAME";

    private boolean nextFlag = false;

    @Autowired
    HeroRepository heroRepo;

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "index")
    public String goIndexJsp(HttpServletRequest request) {
        Hero custom = new Hero();
        custom.setSelectQuary(" sub.count,main.* ");
        custom.setJoinPart(
                " main inner join(select min(id) as id,name as name,count(name) as count from hero group by name order by id) sub on main.id = sub.id");
        custom.setCondition(" and rownum < 30");
        custom.setOrderBy(" sub.count desc,main.master_id,main.id");

        List<Hero> tmpList = (List<Hero>) request.getAttribute("heroList");
        List<Hero> heroList = null == tmpList ? heroRepo.customQuary(custom) : tmpList;

        String jsonDate = JSONArray.toJSONString(heroList);

        // 纯servlet设置
        request.setAttribute("json", jsonDate);
        request.setAttribute("list", heroList);
        request.setAttribute("columnList", getCustomColumn());
        return "Jsp/index";
    }

    @RequestMapping(value = "goDetail")
    public String goDetail(ServletRequest request) {
        String type = request.getParameter("type");
        // 无中生response对象,也可写在方法的参数内
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getResponse();
        String name = "";
        if ("addNew".equals(type)) {
            name = "琳迪斯";
            request.setAttribute("nextFlag", false);
        } else if ("refence".equals(type)) {
            name = getNextNm(request);
        } else {
            Hero cond = new Hero();
            cond.setName("琳迪斯");
            request.setAttribute("heroList", heroRepo.selectByDto(cond));
            request.setAttribute("stringTxt", "ttttt");
            try {
                // 请求转发
                request.getRequestDispatcher("index?name=txt").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        request.setAttribute("list", page2Search(name));
        return "Jsp/detail";

    }

    @RequestMapping(value = "downloadPage")
    public String openDLpage() {

        return "Jsp/download";
    }

    @RequestMapping(value = "download")
    public void fileDownload(HttpServletResponse response) {
        Hero condition = new Hero();
        condition.setId(36);
        condition.setOrderBy("ID");
        List<Hero> heroList = heroRepo.selectByDto(condition);
        response.setContentType("application/octet-stream;charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment; filename=db.csv");
        try {
            PrintWriter out = response.getWriter();
            for (Hero data : heroList) {
                StringBuilder txt = new StringBuilder();
                txt.append(data.getId() + ",");
                txt.append(data.getMasterId() + ",");
                txt.append(data.getTitleName() + ",");
                txt.append(data.getName() + ",");
                txt.append(data.getNickName() + ",");
                txt.append(data.getImgName() + ",");
                txt.append(data.getOrigin() + ",");
                txt.append(data.getHp() + ",");
                txt.append(data.getAttact() + ",");
                txt.append(data.getSpeed() + ",");
                txt.append(data.getDef() + ",");
                txt.append(data.getMdf() + ",");
                txt.append(data.getWeapon() + ",");
                txt.append(data.getSkillA() + ",");
                txt.append(data.getSkillB() + ",");
                txt.append(data.getSkillC() + ",");
                txt.append(data.getSkillD() + ",");
                txt.append(data.getSkillS() + ",");
                txt.append(data.getSkillE() + ",");
                txt.append(data.getLimitPlus() + ",");
                txt.append(data.getDragonFlower() + ",");
                txt.append(data.getSupportMate() + ",");
                txt.append(data.getBlessing() + ",");
                txt.append(data.getMoveType() + ",");
                txt.append(data.getWeaponType() + ",");
                txt.append(data.getColor() + ",");
                txt.append(data.getRace() + ",");
                txt.append(data.getHeroType() + ",");
                txt.append(data.getTeam() + ",");
                txt.append(data.getSkillPoint() + ",");
                txt.append(data.getHeroPoint() + ",");
                txt.append(data.getSpecTag() + ",");
                txt.append(data.getPool() + ",");
                txt.append(data.getFavorite() + ",");
                txt.append(data.getRank() + ",");
                txt.append(data.getCreateDatetime() + ",");
                txt.append(data.getUpdateDatetime() + "\r\n");

                out.print(txt.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "getNext")
    public String showNext(ServletRequest request, HeroRegistForm form) {
        List<Hero> heroList = form.getHeroList();
        for (Hero hero : heroList) {
            System.out.println(hero.getHp());
        }
        String name = getNextNm(request);
        request.setAttribute("list", page2Search(name));
        return "Jsp/detail";
    }

    @RequestMapping(value = "ie5")
    public String ie5(ServletRequest request) {
        return "Jsp/ie5";
    }

    /**
     * 自定义显示列
     */
    private List<String> getCustomColumn() {
        List<String> colunms = new ArrayList<String>();
        colunms.add("NAME");
        colunms.add("IMG_NAME");
        colunms.add("TITLE_NAME");
        colunms.add("ORIGIN");
        colunms.add("WEAPON");
        colunms.add("MOVE_TYPE");
        colunms.add("WEAPON_TYPE");
        return colunms;
    }

    private List<Hero> page2Search(String name) {
        Hero condition = new Hero();
        condition.setSelectQuary(" sub.count,main.* ");
        condition.setJoinPart(
                " main left join(select min(id) as id,name as name,count(name) as count from hero group by name order by id) sub on main.id = sub.id");
        condition.setOrderBy(" main.master_id, sub.count, main.id");
        condition.setCondition(" and main.name = '" + name + "' ");
        return heroRepo.customQuary(condition);
    }

    /**
     * Page2查看page1复选的下一条明细
     *
     * @param request
     * @return
     */
    private String getNextNm(ServletRequest request) {
        // 取得json字符串
        String listTxt = request.getParameter("detailList");
        // json转对象
        List<Hero> selectedList = JSONArray.parseArray(listTxt, Hero.class);
        // 取得检索key
        String name = "";
        if (selectedList.size() > 0) {
            name = selectedList.get(0).getName();
            // 去除
            selectedList.remove(0);
            listTxt = "[" + listTxt.substring(listTxt.indexOf("},") + 2);
        }
        nextFlag = selectedList.size() > 0;
        listTxt = nextFlag ? listTxt : "";
        request.setAttribute("nextFlag", nextFlag);
        request.setAttribute("detailList", listTxt);
        return name;
    }

}
