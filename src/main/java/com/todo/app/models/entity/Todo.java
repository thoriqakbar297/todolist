package com.todo.app.models.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama_list")
    private String namaList;

   
    @OneToMany(mappedBy = "todo", fetch = FetchType.EAGER, cascade = CascadeType.ALL )
    @JsonManagedReference
    private List<Task> task;

    public Todo() { }

    public Todo(String namaList, List<Task> task) {
        this.namaList = namaList;
        this.task = task;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaList() {
        return namaList;
    }

    public void setNamaList(String namaList) {
        this.namaList = namaList;
    }

    public List<Task> getTask() {
        return task;
    }

    public void setTask(List<Task> task) {
        this.task = task;
    }
}
