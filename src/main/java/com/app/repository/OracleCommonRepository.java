package com.app.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OracleCommonRepository{

    int getNextval(@Param("sequenceName")String sequenceName);

    int getCurrentval(@Param("sequenceName")String sequenceName);

}
