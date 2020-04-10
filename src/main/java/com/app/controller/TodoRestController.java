package com.app.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.app.model.Todo;
import com.app.model.TodoResource;
import com.app.service.TodoService;

@Controller
@RequestMapping("todos")
public class TodoRestController {

    @Inject
    TodoService todoService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<TodoResource> getTodos() {
        Collection<Todo> todos = todoService.findAll();
        List<TodoResource> todoResources = new ArrayList<>();
        for (Todo todo : todos) {
            todoResources.add(convert(todo));
        }
        return todoResources;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public TodoResource postTodos(@RequestBody @Validated TodoResource todoResource) {
        todoService.insert(convertToModel(todoResource));
        TodoResource createdTodoResponse = convert(todoService.findCreate());
        return createdTodoResponse;
    }

    @RequestMapping(value = "{todoId}", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public TodoResource getTodo(@PathVariable("todoId") String todoId) {
        Todo todo = todoService.findOne(Integer.parseInt(todoId));
        TodoResource todoResource = convert(todo);
        return todoResource;
    }

    @RequestMapping(value = "{todoId}", method = RequestMethod.PUT)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public TodoResource putTodo(@PathVariable("todoId") String todoId) {
        Todo todo = new Todo();
        todo.setTodoId(Integer.parseInt(todoId));
        todo.setTodoTitle("TestTitleJava");
        todoService.updateById(todo);
        TodoResource finishedTodoResource = convert(todoService.findCreate());
        return finishedTodoResource;
    }

    @RequestMapping(value = "{todoId}", method = RequestMethod.DELETE)
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTodo(@PathVariable("todoId") String todoId) {
        todoService.delete(Integer.parseInt(todoId));
    }

    private TodoResource convert(Todo todo) {
        TodoResource todoResources = new TodoResource();
        todoResources.setTodoId(todo.getTodoId().toString());
        todoResources.setTodoTitle(todo.getTodoTitle());
        todoResources.setCreatedAt(todo.getCreatedAt());
        return todoResources;
    }

    private Todo convertToModel(TodoResource todoResource) {
        Todo todo = new Todo();
        todo.setTodoId(Integer.parseInt(todoResource.getTodoId()));
        todo.setTodoTitle(todoResource.getTodoTitle());
        todo.setCreatedAt(todoResource.getCreatedAt());
        return todo;
    }

}
