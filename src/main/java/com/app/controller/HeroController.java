package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.model.Menu;
import com.app.repository.MenuRepository;
import com.app.util.JsonUtil;

@Controller
@RequestMapping(value = "/hero")
public class HeroController {

    @Autowired
    JsonUtil jsonUtil;

    @Autowired
    MenuRepository menuRepository;

    /**
     * 初期表示
     */
    @RequestMapping(value = "index")
    public String goIndex(Model model) {
        List<Menu> menuList = menuRepository.selectByDto(null);
        model.addAttribute("menuList", menuList);
        return "hero/index";
    }

}
