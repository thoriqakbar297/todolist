package com.todo.app.models.entity;



import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title_task")
    private String titleTask;

    @Column(name = "desc_task")
    private String descTask;
    
   
    @ManyToOne
    @JoinColumn(name = "todo_id")
    @JsonBackReference
    private Todo todo;

    public Task() { }
    public Task(String titleTask, String descTask, Todo todo) {
        this.titleTask = titleTask;
        this.descTask = descTask;
        this.todo = todo;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTitleTask() {
        return titleTask;
    }
    
    public void setTitleTask(String titleTask) {
        this.titleTask = titleTask;
    }
    
    public String getDescTask() {
        return descTask;
    }
    
    public void setDescTask(String descTask) {
        this.descTask = descTask;
    }
    
    public Todo getTodo() {
        return todo;
    }
    
    public void setTodo(Todo todo) {
        this.todo = todo;
    }
}    
