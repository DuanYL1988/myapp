package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import com.app.dto.AjaxResponseDto;
import com.app.form.FarmForm;
import com.app.model.Farm;
import com.app.model.HeroContent;
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
    @RequestMapping(value = "farm")
    public String goIndex(Model model, HttpServletRequest request) {

        String type = request.getParameter("type");
        if (StringUtils.isEmpty(type)) {
            type = "01";
        }
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
        model.addAttribute("farmCnt", service.getFreeCntByLocation());

        return "runeFactory/farm";
    }

    @RequestMapping(value = "seed")
    @ResponseBody
    public AjaxResponseDto insertOrUpdate(@RequestBody @Validated FarmForm form, BindingResult result, Model model) {

        AjaxResponseDto response = new AjaxResponseDto();

        if ("999".equals(form.getSelectCorpId())) {
            HeroContent masterDto = masterResp.selectOneByUniqueKey("9001", "01");
            masterDto.setNameExpand1(form.getGameDate());
            masterResp.update(masterDto);
        } else {
            response = service.seedBatch(form);
        }
        return response;
    }

    @RequestMapping(value = "update")
    public String doUpdate(Model model, FarmForm form) {
        // 土地批量更新
        if ("batch".equals(form.getMode())) {
            service.seedBatch(form);
        }
        // 单个土地更新
        if ("updateFarm".equals(form.getMode())) {
            service.updateFarmInfo(form);
        }
        String type = form.getFarmType();

        Farm searchDto = new Farm();
        searchDto.setLocation(type);
        searchDto.setOrderBy(" PARENT_FARM , INDEX_NUM ");

        List<Farm> farmList = farmResp.selectByDto(searchDto);
        model.addAttribute("jsonDate", jsonUtil.praseObjToJson(farmList));

        model.addAttribute("outPutForm", form);
        model.addAttribute("farmCnt", service.getFreeCntByLocation());

        return "runeFactory/farm";
    }
}
