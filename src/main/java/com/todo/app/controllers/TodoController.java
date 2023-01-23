package com.todo.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todo.app.models.entity.Task;
import com.todo.app.models.entity.Todo;
import com.todo.app.services.TodoService;


@RestController
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping("/todo")
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }

    @GetMapping("/todo-all")
    public List<Todo> getAllTodoWithTask() {
        return todoService.getAllTodoWithTask();
    }

    @DeleteMapping("/todo-lists")
    public void deleteAllTodoList() {
        todoService.deleteAllTodoList();
    }
    @PostMapping("/todo/{todoId}/tasks")
    public ResponseEntity<Task> addTask(@PathVariable Long todoId, @RequestBody Task task) {
        Task newTask = todoService.addTaskToTodoList(todoId, task);
        return ResponseEntity.ok(newTask);
    }
    @DeleteMapping("task/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        todoService.deleteTaskById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("list/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodoListById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/todo/search/{nama}")
    public ResponseEntity<List<Todo>> searchTodoListByNama(@PathVariable String nama) {
        List<Todo> todoLists = todoService.findTodoListByNama(nama);
        if (todoLists.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(todoLists, HttpStatus.OK);
    }
    
   
    




}
