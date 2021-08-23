package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AjaxResponseDto;
import com.app.dto.CategoryDto;
import com.app.form.CommonAjaxForm;
import com.app.model.ContentMaster;
import com.app.repository.ContentMasterRepository;
import com.app.repository.FehCharacterRepository;
import com.app.service.FehService;
import com.app.util.JsonUtil;

@RestController
@RequestMapping("ajax")
public class CommonController {

    @Autowired
    JsonUtil jsonUtil;

    @Autowired
    ContentMasterRepository masterRepository;

    @Autowired
    FehCharacterRepository charActerRepository;

    @Autowired
    FehService fehService;

    @RequestMapping(value = "getInfoByCategory", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponseDto getInfoByCategory(@RequestBody CategoryDto master) {
        AjaxResponseDto result = new AjaxResponseDto();
        ContentMaster category = masterRepository.selectOne(master.getCatagoryId(), master.getCodeId());
        List<ContentMaster> response = new ArrayList<>();
        if (null != category) {
            response = charActerRepository.selectByOrigin(category.getCodeName());
        }
        result.setData(response);
        return result;
    }

    @RequestMapping(value = "testAjax/{aaa}", method = RequestMethod.GET)
    public String testAjax(@PathVariable("aaa") String arg) {
        AjaxResponseDto result = new AjaxResponseDto();
        result.setCode(arg);
        String url = "redirect: fireEmblem/acterInfo/" + arg;
        return url;
    }

    @RequestMapping(value = "saveFavImg", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponseDto saveFavImg(@RequestBody CommonAjaxForm form) {
        return null;
    }

}
