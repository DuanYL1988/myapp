package com.app.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.app.model.Menu;

@Repository
public interface MenuRepository{
    Menu selectOneById(@Param("id")Integer id);

    List<Menu> selectByDto(Menu menu);

    void insert(Menu menu);

    void update(Menu menu);

    int uniqueCheck(@Param("categore")String categore,@Param("name")String name);

    Menu selectOneByUniqueKey(@Param("categore")String categore,@Param("name")String name);

}
