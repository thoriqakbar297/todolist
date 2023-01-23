package com.todo.app.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.app.models.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
    
}
