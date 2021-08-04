package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

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

        Farm inputDto = new Farm();
        String condition = " 1 = 1 ";
        if (StringUtils.isEmpty(form.getSelectCorpId())) {
            inputDto.setCropId("");
            inputDto.setCropNm("");
            inputDto.setCropPrice(null);
            inputDto.setStartDate("");
            // 玉米
            if ("21".equals(form.getFarm().getCropId())) {
                inputDto.setSelectQuary(" HEALTH = 255, CROP_HP = CROP_HP + 100 ");
            }
        } else {
            HeroContent masterInfo = masterResp.selectOneByUniqueKey("1001", form.getSelectCorpId());

            inputDto.setCropId(masterInfo.getCodeId());
            inputDto.setCropNm(masterInfo.getCodeName());
            inputDto.setCropHp(100);
            inputDto.setStartDate(form.getGameDate());
            // 玉米
            if ("21".equals(form.getFarm().getCropId())) {
                condition += " AND INDEX_NUM = 2 ";
            }
        }

        inputDto.setId(0);

        inputDto.setCondition(condition + " AND ID IN (" + form.getFarmIdList() + ")");

        farmResp.update(inputDto);

        result.setCode(CommonContent.RESULT_SUCCESS);
        result.setMessage("更新成功");

        return result;
    }

    @Override
    public void updateFarmInfo(FarmForm form) {
        Farm updDto = form.getFarm();
        if (!StringUtils.isEmpty(updDto.getId() + "")) {
            farmResp.update(updDto);
            // 4整块更新
            if (!StringUtils.isEmpty(updDto.getLocation()) && !StringUtils.isEmpty(updDto.getParentFarm() + "")) {
                Farm parentDto = new Farm();
                parentDto.setId(0);
                parentDto.setCropHp(updDto.getCropHp());
                parentDto.setTotalLevel(updDto.getTotalLevel());
                parentDto.setSizeLevel(updDto.getSizeLevel());
                parentDto.setSpeedLevel(updDto.getSpeedLevel());
                parentDto.setQualityLevel(updDto.getQualityLevel());
                parentDto.setCountLevel(updDto.getCountLevel());
                parentDto.setHealth(updDto.getHealth());

                StringBuilder cond = new StringBuilder();
                cond.append(" PARENT_FARM = " + updDto.getParentFarm());
                cond.append(" AND LOCATION = " + updDto.getLocation());
                parentDto.setCondition(cond.toString());

                farmResp.update(parentDto);
            }
        }
    }

    @Override
    public List<Farm> getFreeCntByLocation() {
        Farm searchDto = new Farm();
        searchDto.setSelectQuary(" location,count(*) as count ");
        searchDto.setCondition(" trim(crop_id) is null ");
        searchDto.setGroupBy(" location ");

        searchDto.setUnionAll(
                " UNION ALL SELECT 'TOTAL' AS location,COUNT(*) as count FROM FARM WHERE TRIM(CROP_ID) IS NULL ORDER BY  location");
        List<Farm> rslt = farmResp.customQuary(searchDto);
        return rslt;
    }
}
