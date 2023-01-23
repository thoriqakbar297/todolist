package com.todo.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.app.models.entity.Task;
import com.todo.app.models.entity.Todo;
import com.todo.app.models.repository.TaskRepository;
import com.todo.app.models.repository.TodoRepository;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private TaskRepository taskRepository;

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }
    public List<Todo> getAllTodoWithTask() {
        return todoRepository.findAll();
    }
    public List<Todo> getAllListWithTask() {
        return todoRepository.findAll();
    }
    public void deleteAllTodoList() {
        todoRepository.deleteAll();
    }

    public Task addTaskToTodoList(Long todoId, Task task) {
        Todo todoList = todoRepository.findById(todoId).orElseThrow();
        task.setTodo(todoList);
        return taskRepository.save(task);
    }

    public void deleteTaskById(Long id) {
        Optional<Task> optTask = taskRepository.findById(id);
        if(optTask.isPresent()){
            Task task = optTask.get();
            Todo todoList = task.getTodo();
            todoList.getTask().remove(task);
            taskRepository.deleteById(id);
            todoRepository.save(todoList);
        }
    }
    public void deleteTodoListById(Long id) {
        todoRepository.deleteById(id);
    }

    public List<Todo> findTodoListByNama(String nama) {
        return todoRepository.findByNamaListContaining(nama);
    }

   
}
