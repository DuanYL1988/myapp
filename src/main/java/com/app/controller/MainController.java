package com.app.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.model.XenoBladeHero;
import com.app.service.UserService;
import com.app.service.XenobladeHeroService;
import com.app.util.JsonUtil;

@Controller
@RequestMapping(value = "/")
public class MainController {
    
    @Inject
    UserService userService;
    
    @Inject
    XenobladeHeroService bladeHeroService;
    
    @Inject
    JsonUtil jsonUtil;

    @RequestMapping(value = "desktop")
    public String goToDesktop(Model model){
        /*
        List<XenoBladeHero> result = bladeHeroService.findAll();
        
        String jsonString = jsonUtil.praseObjToJson(result);
        
        try {
            System.out.println("使用JSONObject转换结果；"+JsonArrayPrase(result));
            System.out.println("使用fastxml转换结果；"+jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //
        model.addAttribute("jsonData", jsonString);
        */
        return "desktop";
    }
    
    @RequestMapping(value="i18n")
    public String getProp(Model model){
        return "i18nProperty/index";
    }
    
    
    @RequestMapping(value = "slickgrid")
    public String goToSlickGrid(Model model){
        
        List<XenoBladeHero> result = bladeHeroService.findAll();
        String jsonString = jsonUtil.praseObjToJson(result);
        
        model.addAttribute("jsonData", jsonString);
        
        return "slickgrid/initialization";
    }
    
    @RequestMapping(value = "slickgrid/openInfo")
    public String slickGridOpenInfo(Model model){
        
        List<XenoBladeHero> result = bladeHeroService.findAll();
        String jsonString = jsonUtil.praseObjToJson(result);
        
        model.addAttribute("jsonData", jsonString);
        
        return "slickgrid/openInfo";
    }
    
    @RequestMapping(value="slickgrid/sample")
    public String goToSample(Model model){
        
        List<XenoBladeHero> result = bladeHeroService.findAll();
        String jsonString = jsonUtil.praseObjToJson(result);
        
        model.addAttribute("jsonData", jsonString);
        
        return "slickgrid/sample";
    }

}
