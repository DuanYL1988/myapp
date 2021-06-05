package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.common.CommonContent;
import com.app.dto.AjaxResponseDto;
import com.app.form.FarmForm;
import com.app.model.Farm;
import com.app.model.HeroContent;
import com.app.repository.FarmRepository;
import com.app.repository.HeroContentRepository;
import com.app.service.RuneFactoryService;

@Service
public class RuneFactoryServiceImpl implements RuneFactoryService {

    @Autowired
    HeroContentRepository masterResp;

    @Autowired
    FarmRepository farmResp;

    @Override
    public AjaxResponseDto seedBatch(FarmForm form) {
        AjaxResponseDto result = new AjaxResponseDto();

        HeroContent masterInfo = masterResp.selectOneByUniqueKey("1001", form.getSelectCorpId());

        Farm inputDto = new Farm();
        inputDto.setCropId(masterInfo.getCodeId());
        inputDto.setCropNm(masterInfo.getCodeName());
        inputDto.setStartDate(form.getGameDate());
        inputDto.setId(0);

        inputDto.setCondition(" ID IN (" + form.getFarmIdList() + ")");

        farmResp.update(inputDto);

        result.setCode(CommonContent.RESULT_SUCCESS);
        result.setMessage("更新成功");

        return result;
    }

}
