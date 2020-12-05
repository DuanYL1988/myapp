package com.app.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.app.model.Hero;
import com.app.model.Universal;

@Repository
public interface OracleCommonRepository {

    int getNextval(@Param("sequenceName") String sequenceName);

    int getCurrentval(@Param("sequenceName") String sequenceName);

    List<Universal> getRoundMaxVal(Hero hero);
}
