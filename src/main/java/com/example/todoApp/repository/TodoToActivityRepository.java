package main.java.com.example.todoApp.repository;

import main.java.com.example.todoApp.model.Todo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TodoToActivityRepository {
    Map<Integer, List<Integer>> todoToActivity;

    public TodoToActivityRepository() {
        todoToActivity = new HashMap<>();
    }

    public List<Integer> get(Integer todoId) {
        if (this.contains(todoId)) {
            return this.todoToActivity.get(todoId);
        }
        throw new RuntimeException("Todo not found");
    }

    public void add(Integer todoId, Integer activityId) {
        this.todoToActivity.computeIfAbsent(todoId, k -> new ArrayList<>()).add(activityId);
    }

    public boolean contains(Integer id) {
        return this.todoToActivity.containsKey(id);
    }

}
