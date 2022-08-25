package main.java.com.example.todoApp.model;

import java.util.ArrayList;
import java.util.List;

public class Todo {
    private Integer id;
    private String name;
    private String description;
    private List<Task> tasks;
    private static Integer counter = 0;

    public Todo(String name, String description) {
        this.id = ++counter;
        this.name = name;
        this.description = description;
        this.tasks = new ArrayList<>();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Task> getTasks() {
        return this.tasks;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

}
