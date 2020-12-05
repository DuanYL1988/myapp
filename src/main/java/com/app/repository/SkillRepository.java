package com.app.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.app.model.Skill;

@Repository
public interface SkillRepository{
    Skill selectOneById(@Param("id")Integer id);

    List<Skill> selectByDto(Skill skill);

    void insert(Skill skill);

    void update(Skill skill);

    int uniqueCheck(@Param("name")String name,@Param("type")String type);

    Skill selectOneByUniqueKey(@Param("name")String name,@Param("type")String type);

}
