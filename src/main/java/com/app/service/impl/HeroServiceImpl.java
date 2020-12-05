package com.app.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.common.CommonContent;
import com.app.dto.AjaxResponseDto;
import com.app.form.HeroRegistForm;
import com.app.form.HeroSearchForm;
import com.app.model.Hero;
import com.app.model.HeroContent;
import com.app.model.HeroMaster;
import com.app.model.SkillInfo;
import com.app.model.Universal;
import com.app.repository.HeroContentRepository;
import com.app.repository.HeroMasterRepository;
import com.app.repository.HeroRepository;
import com.app.repository.OracleCommonRepository;
import com.app.repository.SkillInfoRepository;
import com.app.service.HeroService;
import com.app.service.SkillInfoService;
import com.app.util.CommonUtils;

@Service
public class HeroServiceImpl implements HeroService {

    @Autowired
    CommonUtils commonUtil;

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
    public Map<String, List<Hero>> doSearch(HeroSearchForm form) {

        String orderKey = "WEAPON_TYPE";
        String keyName = "0002-" + commonUtil.changeNm(orderKey, false);

        Hero condition = form.getHero();
        condition.setOrderBy(orderKey);

        List<Hero> searchList = heroRepo.selectByDto(condition);

        return commonUtil.groupByList(keyName, searchList);
    }

    @Override
    public AjaxResponseDto heroRegist(HeroRegistForm form) {

        AjaxResponseDto result = new AjaxResponseDto();
        Hero input = form.getHero();

        if (CommonContent.MODE_INSERT.equals(form.getMode())) {
            if (!doInsert(input)) {
                // 重复登录check
                result.setCode("1");
                result.setMessage("该数据已登录");
                return result;
            }
        } else {
            heroRepo.update(input);
        }

        // 武器情报
        SkillInfo weapon = skillRepo.selectOneByUniqueKey(input.getWeapon(), "W");
        if (null == weapon) {
            skillService.registFromHero(input.getWeapon(), form.getWeaponInfo(), "W", form.getExtendWeapon());
        }

        result.setData(input.getTitleName() + ";" + input.getName());
        result.setCode("0");
        result.setMessage("SUCCESS");

        return result;
    }

    /**
     * 右侧详细情报
     */
    @Override
    public AjaxResponseDto getAjaxHeroInfo(Integer id) {
        AjaxResponseDto result = new AjaxResponseDto();
        Hero hero = heroRepo.selectOneById(id);
        List<Universal> roundInfo = oracleRepo.getRoundMaxVal(hero);

        result.setData(hero);
        result.setListData01(roundInfo);

        return result;
    }

    private boolean doInsert(Hero input) {
        int cnt = heroRepo.uniqueCheck(input.getTitleName(), input.getName());
        if (cnt > 0) {
            return false;
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
        return true;
    }
}
