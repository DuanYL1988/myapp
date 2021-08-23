package com.app.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.app.model.Servant;

@Repository
public interface ServantRepository{
    Servant selectOneById(@Param("id")Integer id);

    List<Servant> selectByDto(Servant servant);

    void insert(Servant servant);

    void update(Servant servant);

    int uniqueCheck(@Param("imgName")String imgName);

    Servant selectOneByUniqueKey(@Param("imgName")String imgName);

    List<Servant> customQuary(Servant servant);

}
