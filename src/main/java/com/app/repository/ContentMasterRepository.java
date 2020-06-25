package com.app.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.app.model.ContentMaster;

@Repository
public interface ContentMasterRepository {

    void insert(ContentMaster content);

    void insertSql(String sqlString);

    List<ContentMaster> getContentByCategoryId(String categoryId);

    List<ContentMaster> getContentByDto(ContentMaster content);

    ContentMaster selectOne(@Param("categoryId") String categoryId,@Param("codeId") String codeId);
}
