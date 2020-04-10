package com.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.model.Todo;
import com.app.repository.TodoRepository;
import com.app.service.TodoService;


@Service
public class TodoServiceImpl implements TodoService{
	
	@Resource
	private TodoRepository todoRepository;
	
	@Override
	public List<Todo> findAll() {
		System.out.println("-------TodoService.findAll--------");
		return createDummyData();
	}
	
	@Override
	public Todo findCreate() {
		System.out.println("-------TodoService.findCreate--------");
		return todoRepository.findCreate();
	}
	
	//selectByPrimaryKey
	public Todo findOne(int todoId) {
		System.out.println("-------TodoService.findOne--------");
		return todoRepository.selectByPrimaryKey(todoId);
	}

	@Override
	public void insert(Todo todo) {
		System.out.println("-------TodoService.insert--------");
		todoRepository.insert(todo);
	}

	@Override
	public int updateById(Todo todo) {
		System.out.println("-------TodoService.updateById--------");
		return todoRepository.updateByPrimaryKey(todo);
	}

	@Override
	public void delete(int todoId) {
		System.out.println("-------TodoService.delete--------");
		todoRepository.deleteByPrimaryKey(todoId);
	}
	
	private List<Todo> createDummyData(){
		List<Todo> todoResources = new ArrayList<>();
		todoResources = todoRepository.findAll();
		if(todoResources.size()==0){
			for(int i = 0;i<10;i++){
				Todo todo = new Todo();
				todo.setTodoId(i);
				todo.setTodoTitle("TodoTitle"+i);
				todo.setCreatedAt(new Date());
				todoResources.add(todo);
			}
		}
		return todoResources;
	}
}
