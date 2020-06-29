package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.AjaxResponseDto;
import com.app.form.HeroRegistForm;
import com.app.model.Hero;
import com.app.model.HeroContent;
import com.app.model.HeroMaster;
import com.app.model.SkillInfo;
import com.app.repository.HeroContentRepository;
import com.app.repository.HeroMasterRepository;
import com.app.repository.HeroRepository;
import com.app.repository.OracleCommonRepository;
import com.app.repository.SkillInfoRepository;
import com.app.service.HeroService;
import com.app.service.SkillInfoService;

@Service
public class HeroServiceImpl implements HeroService {

    @Autowired
    HeroRepository heroRepo;

    @Autowired
    HeroMasterRepository heroMasterRepo;

    @Autowired
    HeroContentRepository heroContRepo;

    @Autowired
    OracleCommonRepository oracleRepo;

    @Autowired
    SkillInfoRepository skillRepo;

    @Autowired
    SkillInfoService skillService;

    @Override
    public AjaxResponseDto heroRegist(HeroRegistForm form) {

        AjaxResponseDto result = new AjaxResponseDto();

        Hero input = form.getHero();
        // 重复登录check
        int cnt = heroRepo.uniqueCheck(input.getTitleName(), input.getName());
        if (cnt > 0) {
            result.setCode("1");
            result.setMessage("该数据已登录");
            return result;
        }

        // MASTER中是否已登录
        HeroMaster hm = heroMasterRepo.selectOneByUniqueKey(input.getOrigin(), input.getName());
        if (null == hm) {
            // 查找作品名
            HeroContent rst = heroContRepo.selectOneByUniqueKey("0004", input.getOrigin());

            // MASTER登录
            hm = new HeroMaster();
            hm.setOriginId(input.getOrigin());
            hm.setOriginName(rst.getCodeName());
            hm.setName(input.getName());
            // 登录
            heroMasterRepo.insert(hm);
            // 登录的当期ID
        }

        input.setMasterId(oracleRepo.getCurrentval("SEQ_HERO_MASTER"));
        input.setOrigin(hm.getOriginName());
        heroRepo.insert(input);

        // 武器情报
        SkillInfo weapon = skillRepo.selectOneByUniqueKey(input.getWeapon(), "W");
        if(null == weapon) {
            skillService.registFromHero(input.getWeapon(), form.getWeaponInfo(), "W", form.getExtendWeapon());
        }

        result.setCode("0");
        result.setMessage("SUCCESS");

        return result;
    }

}
