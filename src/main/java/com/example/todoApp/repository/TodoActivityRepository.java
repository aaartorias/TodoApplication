package main.java.com.example.todoApp.repository;

import main.java.com.example.todoApp.model.TodoActivity;
import main.java.com.example.todoApp.model.User;

import java.util.Map;

public class TodoActivityRepository {
    Map<Integer, TodoActivity> idToActivity;

    public TodoActivity get(Integer id) {
        if (this.contains(id)) {
            return this.idToActivity.get(id);
        }
        throw new RuntimeException("User not found");
    }

    public void add(TodoActivity activity) {
        this.idToActivity.put(activity.getId(), activity);
    }

    public boolean contains(Integer activityId) {
        return this.idToActivity.containsKey(activityId);
    }
}
