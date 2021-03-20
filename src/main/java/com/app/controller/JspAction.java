package com.app.controller;

import java.util.List;

import javax.servlet.ServletRequest;

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

    @Autowired
    HeroRepository heroRepo;

    @RequestMapping(value = "index")
    public String goIndexJsp(Model model) {
        Hero custom = new Hero();
        custom.setSelectQuary(" sub.count,main.* ");
        custom.setJoinPart(
                " main inner join(select min(id) as id,name as name,count(name) as count from hero group by name order by id) sub on main.id = sub.id");
        custom.setCondition(" and rownum < 30");
        custom.setOrderBy(" sub.count desc,main.master_id,main.id");
        List<Hero> heroList = heroRepo.customQuary(custom);

        String jsonDate = JSONArray.toJSONString(heroList);

        model.addAttribute("list", heroList);
        model.addAttribute("json", jsonDate);
        return "Jsp/index";
    }

    @RequestMapping(value = "goDetail")
    public String goDetail(ServletRequest request, Model model) {
        String type = request.getParameter("type");
        String listTxt = request.getParameter("detailList");
        List<Hero> selectedList = JSONArray.parseArray(listTxt, Hero.class);
        Hero condition = new Hero();
        StringBuilder cond = new StringBuilder();
        condition.setSelectQuary(" sub.count,main.* ");
        condition.setJoinPart(
                " main left join(select min(id) as id,name as name,count(name) as count from hero group by name order by id) sub on main.id = sub.id");
        condition.setOrderBy(" main.master_id, sub.count, main.id");
        if ("addNew".equals(type)) {
            condition.setCondition(" main.name = '琳迪斯' ");
        } else if (selectedList.size() > 0) {
            cond.append(" and main.name in (");
            for (int i = 0; i < selectedList.size(); i++) {
                cond.append("'").append(selectedList.get(i).getName()).append("',");
            }
            cond.append("'')");
            condition.setCondition(cond.toString());
        } else {
            return "redirect: jsp/index";
        }
        List<Hero> heroList = heroRepo.customQuary(condition);
        model.addAttribute("list", heroList);
        return "Jsp/detail";

    }
}
