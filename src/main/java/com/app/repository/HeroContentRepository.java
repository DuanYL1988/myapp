package com.app.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.app.model.HeroContent;

@Repository
public interface HeroContentRepository{
    HeroContent selectOneById(@Param("id")Integer id);

    List<HeroContent> selectByDto(HeroContent heroContent);

    void insert(HeroContent heroContent);

    void update(HeroContent heroContent);

    int uniqueCheck(@Param("categoryId")String categoryId,@Param("codeId")String codeId);

    HeroContent selectOneByUniqueKey(@Param("categoryId")String categoryId,@Param("codeId")String codeId);

    List<HeroContent> customQuary(HeroContent heroContent);

}
