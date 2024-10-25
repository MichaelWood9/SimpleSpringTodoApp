package com.example.todoApp.Todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository repository;

    @Autowired
    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public List<Todo> getTodos(){
        return  repository.findAll();
    }

    public void addTodo(Todo todo){
        repository.save(todo);
    }

    public void deleteTodo(Long todoId){
        boolean exists = repository.existsById(todoId);
        if (!exists){
            throw new IllegalStateException("todo with id " + todoId + " does not exist");
        }
        repository.deleteById(todoId);
    }
    public Todo getTodo(Long todoId){
        Optional<Todo> todoOptional = repository.findById(todoId);//repository.getById(todoId);
        Todo todo = todoOptional.get();
        return todo;
    }
    public void updateTodo(Todo todo){
        System.out.println(todo.getId());

        repository.save(todo);
    }
}
