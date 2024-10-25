package com.example.todoApp.Todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "api/v1/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public String getTodo(Model model){
        model.addAttribute("List", todoService.getTodos());
        return"todo";
    }

    @GetMapping("/addTodo")
    public String getAddTodo(Model model){
        model.addAttribute("todoItem", new Todo());
        return "AddTodo";
    }
    @PostMapping
    public String addNewTodo(@ModelAttribute Todo todoItem){
        todoService.addTodo(todoItem);
        return "redirect:/api/v1/todo";
    }

    @GetMapping(path = "delete/{todoId}")
    public String deleteTodo(@PathVariable("todoId")Long todoId){
        todoService.deleteTodo(todoId);
        return "redirect:/api/v1/todo";
    }
    @GetMapping(path = "update/{todoId}")
    public String getUpdateTodo(@PathVariable("todoId")Long todoId, Model model){
        model.addAttribute("todo",todoService.getTodo(todoId));
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(todoId);
        return "UpdateTodo";
    }
    @PostMapping("/updateTodo")
    public String updateTodo(@ModelAttribute Todo todo){

        System.out.println(todo.getId());
        System.out.println(todo.getName());
        todoService.updateTodo(todo);
        return "redirect:/api/v1/todo";
    }

}
