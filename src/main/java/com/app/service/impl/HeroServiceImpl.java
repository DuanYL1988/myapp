package com.app.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import com.app.common.CommonContent;
import com.app.dto.AjaxResponseDto;
import com.app.form.HeroRegistForm;
import com.app.form.HeroSearchForm;
import com.app.model.Hero;
import com.app.model.HeroContent;
import com.app.model.HeroMaster;
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
    public Map<String, List<Hero>> doGroupSearch(HeroSearchForm form) {

        String orderKey = "WEAPON_TYPE";
        String keyName = "0002-" + commonUtil.changeNm(orderKey, false);

        Hero condition = form.getHero();
        condition.setOrderBy(orderKey);

        List<Hero> searchList = heroRepo.selectByDto(condition);

        return commonUtil.groupByList(keyName, searchList);
    }

    /**
     * 检索
     */
    @Override
    public List<Hero> doSearch(HeroSearchForm form) {
        Hero condition = form.getHero();
        editCondition(condition);
        condition.setOrderBy("ID");

        List<Hero> searchList = heroRepo.selectByDto(condition);

        return searchList;
    }

    /**
     * 单条记录更新
     */
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
        result.setData(hero);

        List<Universal> roundInfo = oracleRepo.getRoundMaxVal(hero);
        result.setListData01(roundInfo);

        // 相同人物
        Hero cond1 = new Hero();
        cond1.setCondition(" AND ID <> " + id + " AND MASTER_ID = " + hero.getMasterId() + " ");
        List<Hero> teamInfo = heroRepo.selectByDto(cond1);
        result.setListData02(teamInfo);

        return result;
    }

    /**
     * 角色登录
     *
     * @param input
     * @return
     */
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

    /**
     * 编队更新
     *
     * @param form
     * @return
     */
    @Override
    public AjaxResponseDto updateTeam(HeroRegistForm form) {
        AjaxResponseDto result = new AjaxResponseDto();
        // 队伍编号
        String teamNo = form.getTeamNo();
        String teamMember = form.getTeamMember();
        if (StringUtils.isEmpty(teamNo) || StringUtils.isEmpty(teamMember)) {
            result.setCode("ERROR");
            return result;
        }

        // 重置编队信息
        Hero updObj = new Hero();
        updObj.setId(5000);
        updObj.setTeam(99);
        updObj.setCondition(" TEAM = " + teamNo + " ");
        heroRepo.update(updObj);

        Hero cond2 = new Hero();
        cond2.setId(0);
        cond2.setTeam(Integer.parseInt(teamNo));
        teamMember += "0";
        cond2.setCondition(" ID IN (" + teamMember + ") ");
        heroRepo.update(cond2);

        result.setCode("SUCCESS");
        return result;
    }

    /**
     * 编辑自定义检索条件
     *
     * @param condition
     */
    private void editCondition(Hero condition) {
        String cond = editQuary("MOVE_TYPE", condition.getMoveType());
        String quary = condition.getCondition();
        if (StringUtils.isEmpty(quary)) {
            quary = "";
        }

        if (!StringUtils.isEmpty(cond)) {
            condition.setMoveType("");
            condition.setCondition(quary + cond);
        }

    }

    private String editQuary(String col, String val) {
        StringBuilder cond = new StringBuilder();
        if (!StringUtils.isEmpty(val) && val.indexOf(",") > 0) {
            cond.append(" AND " + col + " IN (" + val + ") ");
            return cond.toString();
        } else {
            return null;
        }
    }
}
