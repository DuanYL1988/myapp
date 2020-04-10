package com.app.repository;

import org.springframework.stereotype.Repository;

import com.app.model.User;

@Repository
public interface UserRepository {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}