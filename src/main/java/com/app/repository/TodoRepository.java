package com.app.repository;

import java.util.List;

import com.app.model.Todo;


public interface TodoRepository {
	
    int deleteByPrimaryKey(Integer id);

    int insert(Todo todo);

    Todo selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Todo todo);
    
    List<Todo> findAll();
    
    Todo findCreate();
}