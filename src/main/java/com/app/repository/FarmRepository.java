package com.app.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.app.model.Farm;

@Repository
public interface FarmRepository{
    Farm selectOneById(@Param("id")Integer id);

    List<Farm> selectByDto(Farm farm);

    void insert(Farm farm);

    void update(Farm farm);

    int uniqueCheck(@Param("location")String location,@Param("parentFarm")String parentFarm,@Param("indexNum")String indexNum);

    Farm selectOneByUniqueKey(@Param("location")String location,@Param("parentFarm")String parentFarm,@Param("indexNum")String indexNum);

    List<Farm> customQuary(Farm farm);

}
