package main.java.com.example.todoApp.repository;

import main.java.com.example.todoApp.model.Todo;

import java.util.HashMap;
import java.util.Map;

public class TodoRepository {
    private Map<Integer, Todo> todoIdToList;

    public TodoRepository() {
        this.todoIdToList = new HashMap<>();
    }

    public Todo get(Integer id) {
        if (this.todoIdToList.containsKey(id)) {
            return this.todoIdToList.get(id);
        }
        throw new RuntimeException("Todo list not found");
    }

    public void add(Todo todo) {
        this.todoIdToList.put(todo.getId(), todo);
    }
}
