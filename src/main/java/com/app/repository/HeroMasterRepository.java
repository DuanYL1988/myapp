package com.app.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.app.model.HeroMaster;

@Repository
public interface HeroMasterRepository{
    HeroMaster selectOneById(@Param("id")Integer id);

    List<HeroMaster> selectByDto(HeroMaster heroMaster);

    void insert(HeroMaster heroMaster);

    void update(HeroMaster heroMaster);

    int uniqueCheck(@Param("originId")String originId,@Param("name")String name);

    HeroMaster selectOneByUniqueKey(@Param("originId")String originId,@Param("name")String name);

}
