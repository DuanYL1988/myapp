package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
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

    @RequestMapping(value = "index")
    public String goIndexJsp(HttpServletRequest request, Model model) {
        Hero custom = new Hero();
        custom.setSelectQuary(" sub.count,main.* ");
        custom.setJoinPart(
                " main inner join(select min(id) as id,name as name,count(name) as count from hero group by name order by id) sub on main.id = sub.id");
        custom.setCondition(" and rownum < 30");
        custom.setOrderBy(" sub.count desc,main.master_id,main.id");

        List<Hero> heroList = heroRepo.customQuary(custom);

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

        String name = "";
        if ("addNew".equals(type)) {
            name = "琳迪斯";
            request.setAttribute("nextFlag", false);
        } else if ("refence".equals(type)) {
            name = getNextNm(request);
        } else {
            return "redirect: jsp/index";
        }
        request.setAttribute("list", page2Search(name));
        return "Jsp/detail";

    }

    @RequestMapping(value = "getNext")
    public String showNext(ServletRequest request) {
        String name = getNextNm(request);
        request.setAttribute("list", page2Search(name));
        return "Jsp/detail";
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
