package com.app.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.model.Skill;

@Repository
public interface SkillRepository {

    List<Skill> getSkillListBySkillType(String type);

    void insert(Skill skill);
    
    void udate(Skill skill);

    List<Skill> getAllSkill();

}
