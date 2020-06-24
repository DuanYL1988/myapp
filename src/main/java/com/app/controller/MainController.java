package com.app.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.util.JsonUtil;

@Controller
@RequestMapping(value = "/")
public class MainController {

    @Inject
    JsonUtil jsonUtil;

    @RequestMapping(value = "desktop")
    public String goToDesktop(Model model){
        /*
        String jsonString = jsonUtil.praseObjToJson(result);

            System.out.println("使用JSONObject转换结果；"+JsonArrayPrase(result));
            System.out.println("使用fastxml转换结果；"+jsonString);
        */
        return "desktop";
    }

    @RequestMapping(value="i18n")
    public String getProp(Model model){
        return "i18nProperty/index";
    }


    @RequestMapping(value = "slickgrid")
    public String goToSlickGrid(Model model){
        model.addAttribute("jsonData", "");

        return "slickgrid/initialization";
    }

    @RequestMapping(value = "slickgrid/openInfo")
    public String slickGridOpenInfo(Model model){
        model.addAttribute("jsonData", "");

        return "slickgrid/openInfo";
    }

    @RequestMapping(value="slickgrid/sample")
    public String goToSample(Model model){

        model.addAttribute("jsonData", "");
        return "slickgrid/sample";
    }

}
