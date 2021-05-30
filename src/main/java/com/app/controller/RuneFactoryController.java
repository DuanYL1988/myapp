package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.dto.AjaxResponseDto;
import com.app.form.FarmForm;
import com.app.model.Farm;
import com.app.repository.FarmRepository;
import com.app.repository.HeroContentRepository;
import com.app.service.RuneFactoryService;
import com.app.util.CommonUtils;
import com.app.util.JsonUtil;

@Controller
@RequestMapping(value = "/rune")
public class RuneFactoryController {

    @Autowired
    JsonUtil jsonUtil;

    @Autowired
    CommonUtils commonUtil;

    @Autowired
    FarmRepository farmResp;

    @Autowired
    HeroContentRepository masterResp;

    @Autowired
    RuneFactoryService service;

    /**
     * 农田信息
     */
    @RequestMapping(value = "farm/{type}")
    public String goIndex(@PathVariable("type") String type, Model model) {
        Farm searchDto = new Farm();
        searchDto.setLocation(type);
        searchDto.setOrderBy(" PARENT_FARM , INDEX_NUM ");

        List<Farm> farmList = farmResp.selectByDto(searchDto);
        // model.addAttribute("list", farmList);
        model.addAttribute("jsonDate", jsonUtil.praseObjToJson(farmList));

        String gameDate = masterResp.selectOneByUniqueKey("9001", "01").getNameExpand1();
        FarmForm outPutForm = new FarmForm();
        outPutForm.setGameDate(gameDate);
        outPutForm.setFarmType(type);

        model.addAttribute("outPutForm", outPutForm);

        return "runeFactory/farm";
    }

    @RequestMapping(value = "seed")
    @ResponseBody
    public AjaxResponseDto insertOrUpdate(@RequestBody @Validated FarmForm form, BindingResult result, Model model) {
        AjaxResponseDto response = service.seedBatch(form);
        return response;
    }
}
