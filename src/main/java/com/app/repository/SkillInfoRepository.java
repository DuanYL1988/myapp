package com.app.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.app.model.SkillInfo;

@Repository
public interface SkillInfoRepository{
    SkillInfo selectOneById(@Param("id")Integer id);

    List<SkillInfo> selectByDto(SkillInfo skillInfo);

    void insert(SkillInfo skillInfo);

    void update(SkillInfo skillInfo);

    int uniqueCheck(@Param("name")String name,@Param("type")String type);

    SkillInfo selectOneByUniqueKey(@Param("name")String name,@Param("type")String type);

}
