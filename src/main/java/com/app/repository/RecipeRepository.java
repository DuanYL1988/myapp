package com.app.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.app.model.Recipe;

@Repository
public interface RecipeRepository{
    Recipe selectOneById(@Param("id")Integer id);

    List<Recipe> selectByDto(Recipe recipe);

    void insert(Recipe recipe);

    void update(Recipe recipe);

    int uniqueCheck(@Param("categoryMain")String categoryMain,@Param("categorySub")String categorySub,@Param("name")String name);

    Recipe selectOneByUniqueKey(@Param("categoryMain")String categoryMain,@Param("categorySub")String categorySub,@Param("name")String name);

    List<Recipe> customQuary(Recipe recipe);

}
