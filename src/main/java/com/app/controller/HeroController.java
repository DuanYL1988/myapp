package com.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import com.app.common.CommonContent;
import com.app.dto.AjaxResponseDto;
import com.app.form.HeroRegistForm;
import com.app.form.HeroSearchForm;
import com.app.model.Hero;
import com.app.model.Menu;
import com.app.repository.HeroRepository;
import com.app.repository.MenuRepository;
import com.app.service.HeroService;
import com.app.util.CommonUtils;
import com.app.util.JsonUtil;

@Controller
@RequestMapping(value = "/hero")
public class HeroController {

    @Autowired
    JsonUtil jsonUtil;

    @Autowired
    CommonUtils commonUtil;

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    HeroService service;

    @Autowired
    HeroRepository heroRepo;

    /**
     * 初期表示
     */
    @RequestMapping(value = "index")
    public String goIndex(Model model) {
        List<Menu> menuList = menuRepository.selectByDto(null);
        model.addAttribute("menuList", menuList);
        return "hero/index";
    }

    /**
     * 结果list
     *
     * @param model
     * @param form
     * @return
     */
    @RequestMapping(value = "search")
    public String doSearch(Model model, HeroSearchForm form, HttpServletRequest request) {
        // Menu请求中有参数
        String type = request.getParameter("type");

        if (null == form.getHero()) {
            Hero condition = new Hero();
            // 设置检索参数
            if (!StringUtils.isEmpty(type)) {
                setSearchType(condition, type);
            }
            form.setHero(condition);
            form.setMode("search");
            form.setGroup("A");
        }

        // 使用thymeleaf标签生成页面
//        Map<String, List<Hero>> resultMapList = new HashMap<String, List<Hero>>();

        // 使用Json在JS中生成页面内容
        List<Hero> heroList = service.doSearch(form);
        String jsonDate = "";
        if ("A".equals(form.getGroup())) {
            jsonDate = jsonUtil.praseObjToJson(commonUtil.groupByList("weaponType", heroList));
//            resultMapList = commonUtil.groupByList("weaponType", heroList);
        } else if ("B".equals(form.getGroup())) {
            jsonDate = jsonUtil.praseObjToJson(commonUtil.groupByList("color", heroList));
        } else if ("C".equals(form.getGroup())) {
            jsonDate = jsonUtil.praseObjToJson(commonUtil.groupByList("moveType", heroList));
        }
        model.addAttribute("jsonDate", jsonDate);
//        model.addAttribute("resultMapList", resultMapList);

        model.addAttribute("form", form);
        return "hero/hero_list";
    }

    /**
     * 组队
     *
     * @param model
     * @param form
     * @return
     */
    @RequestMapping(value = "team")
    public String editTeam(Model model, HeroSearchForm form) {

        // 使用Json在JS中生成页面内容
        form.setHero(new Hero());
        List<Hero> heroList = service.doSearch(form);
        String jsonDate = jsonUtil.praseObjToJson(commonUtil.groupByList("moveType", heroList));
        model.addAttribute("jsonDate", jsonDate);

        //
        Map<String, List<Hero>> teamMap = new HashMap<String, List<Hero>>();
        for (int i = 1; i < 21; i++) {
            Hero cond02 = new Hero();
            cond02.setCondition(" AND TEAM = " + i + " ");
            cond02.setOrderBy(" TEAM ");
            List<Hero> teamList = heroRepo.selectByDto(cond02);
            // 队员
            for (int j = teamList.size(); j < 4; j++) {
                teamList.add(new Hero());
            }
            teamMap.put(String.valueOf(i), teamList);
        }
        model.addAttribute("form", form);
        model.addAttribute("teamMap", teamMap);

        return "hero/team";
    }

    /**
     * 登录页面
     */
    @RequestMapping(value = "regist/{acterId}")
    public String goRegist(@PathVariable("acterId") String acterId, Model model, HttpSession session) {

        session.removeAttribute(CommonContent.SESSION_PRE_ID);

        HeroRegistForm inputForm = new HeroRegistForm();
        Hero hero = heroRepo.selectOneById(Integer.parseInt(acterId));
        inputForm.setHero(null == hero ? new Hero() : hero);

        model.addAttribute("inputForm", inputForm);
        return "hero/regist";
    }

    @RequestMapping(value = "regist/excute")
    public String doRegist(Model model, HeroRegistForm form, HttpSession session) {
        // 判断是更新还是新规
        String id = form.getHero().getId() + "";

        if (id.length() > 0) {
            form.setMode(CommonContent.MODE_UPDATE);
        } else {
            form.setMode(CommonContent.MODE_INSERT);
        }

        AjaxResponseDto result = service.heroRegist(form);

        model.addAttribute("inputForm", form);
        model.addAttribute("result", result);

        return "hero/regist";
    }

    /**
     * 更新角色信息
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "detail/{id}")
    public String getDetail(@PathVariable("id") Integer id, Model model) {
        Hero hero = new Hero();
        HeroRegistForm inputForm = new HeroRegistForm();
        if (id > 0) {
            hero = heroRepo.selectOneById(id);
        }
        inputForm.setHero(hero);
        model.addAttribute("inputForm", inputForm);
        return "hero/regist";
    }

    /**
     * 打开详细区域
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "openLeftInfo/{id}")
    @ResponseBody
    public AjaxResponseDto openLeftInfo(@PathVariable("id") Integer id) {
        AjaxResponseDto result = service.getAjaxHeroInfo(id);

        return result;
    }

    @RequestMapping(value = "ajaxSearch")
    @ResponseBody
    public AjaxResponseDto ajaxSearch(@RequestBody HeroSearchForm form) {
        AjaxResponseDto result = new AjaxResponseDto();

        List<Hero> heroList = service.doSearch(form);
        result.setData(commonUtil.groupByList("weaponType", heroList));

        return result;
    }

    /**
     * 编队更新
     *
     * @param form
     * @return
     */
    @RequestMapping(value = "updateTeam")
    @ResponseBody
    public AjaxResponseDto updateTeam(@RequestBody HeroRegistForm form) {
        AjaxResponseDto result = service.updateTeam(form);

        return result;
    }

    private void setSearchType(Hero condition, String type) {
        if ("armor".equals(type)) {
            condition.setMoveType("04");
        } else if ("fly".equals(type)) {
            condition.setMoveType("03");
        } else if ("knight".equals(type)) {
            condition.setMoveType("02");
        } else if ("foot".equals(type)) {
            condition.setMoveType("01");
        }
    }
}
