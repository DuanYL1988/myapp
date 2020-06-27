package com.app.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.app.model.Hero;

@Repository
public interface HeroRepository{
    Hero selectOne(@Param("id")Integer id);

    List<Hero> selectByDto(Hero hero);

    void insert(Hero hero);

    void update(Hero hero);

    int uniqueCheck(@Param("titleName")String titleName,@Param("name")String name);

}