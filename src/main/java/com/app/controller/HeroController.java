package com.app.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.common.CommonContent;
import com.app.dto.AjaxResponseDto;
import com.app.form.HeroRegistForm;
import com.app.form.HeroSearchForm;
import com.app.model.Hero;
import com.app.model.Menu;
import com.app.repository.MenuRepository;
import com.app.service.HeroService;
import com.app.util.JsonUtil;

@Controller
@RequestMapping(value = "/hero")
public class HeroController {

    @Autowired
    JsonUtil jsonUtil;

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    HeroService service;

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
     * 登录页面
     */
    @RequestMapping(value = "regist")
    public String goRegist(Model model,HttpSession session) {

        session.removeAttribute(CommonContent.SESSION_PRE_ID);

        HeroRegistForm inputForm = new HeroRegistForm();
        Hero hero = new Hero();
        inputForm.setHero(hero);

        model.addAttribute("inputForm", inputForm);
        return "hero/regist";
    }

    @RequestMapping(value = "regist/excute")
    public String doRegist(Model model,HeroRegistForm form,HttpSession session) {
        AjaxResponseDto result = service.heroRegist(form);

        // 判断是更新还是新规
        String priId = (String)session.getAttribute(CommonContent.SESSION_PRE_ID);
        if (priId.equals(form.getHero().getTitleName()+";"+form.getHero().getName())) {
            form.setMode(CommonContent.MODE_UPDATE);
        }

        HeroRegistForm inputForm = new HeroRegistForm();
        Hero hero = new Hero();
        inputForm.setHero(hero);

        model.addAttribute("inputForm", inputForm);
        model.addAttribute("result", result);
        return "hero/regist";
    }

    @RequestMapping(value = "search")
    public String doSearch(Model model,HeroSearchForm form) {

        if (null == form.getHero()) {
            form.setHero(new Hero());
            form.setMode("search");
        }

        Map<String, List<Hero>> resultMapList = service.doSearch(form);

        model.addAttribute("form", form);
        model.addAttribute("resultMapList", resultMapList);
        return "hero/hero_list";
    }
}
