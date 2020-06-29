package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.SkillInfo;
import com.app.repository.SkillInfoRepository;
import com.app.service.SkillInfoService;

@Service
public class SkillInfoServiceImpl implements SkillInfoService {

    @Autowired
    SkillInfoRepository repository;

    @Override
    public void registFromHero(String name,String info,String skillType,String extend) {
        SkillInfo skill = new SkillInfo();
        skill.setName(name);
        skill.setType(skillType);
        skill.setInfo(info);
        skill.setExtend(extend);
        repository.insert(skill);
    }

}
