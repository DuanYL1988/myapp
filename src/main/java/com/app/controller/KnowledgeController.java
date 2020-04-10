package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/rigstTable")
public class KnowledgeController {

    private static final String INIT_PAGE = "knowledge/regist";

    public String initPage() {
        
        return INIT_PAGE;
    }
}
