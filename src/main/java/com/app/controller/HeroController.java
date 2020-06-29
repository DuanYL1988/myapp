package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dto.AjaxResponseDto;
import com.app.form.HeroRegistForm;
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

        HeroRegistForm inputForm = new HeroRegistForm();
        Hero hero = new Hero();
        inputForm.setHero(hero);

        model.addAttribute("inputForm", inputForm);
        return "hero/regist";
    }

    @RequestMapping(value = "regist/excute")
    public String doRegist(Model model,HeroRegistForm form) {
        AjaxResponseDto result = service.heroRegist(form);

        HeroRegistForm inputForm = new HeroRegistForm();
        Hero hero = new Hero();
        inputForm.setHero(hero);

        model.addAttribute("inputForm", inputForm);
        model.addAttribute("result", result);
        return "hero/regist";
    }
}
