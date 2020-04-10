package com.app.service;

import java.util.List;

import com.app.model.Todo;

public interface TodoService {
	
	List<Todo> findAll();
	
	void insert(Todo todo);
	
	int updateById(Todo todo);
	
	void delete(int todoId);
	
	Todo findCreate();
	
	Todo findOne(int todoId);
	
}
