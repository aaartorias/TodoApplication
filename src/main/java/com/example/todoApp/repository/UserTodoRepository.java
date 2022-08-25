package main.java.com.example.todoApp.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserTodoRepository {
    private Map<Integer, List<Integer>> userIdToTodoId;

    public UserTodoRepository() {
        userIdToTodoId = new HashMap<>();
    }

    public void add(Integer userId, Integer todoId) {
        userIdToTodoId.computeIfAbsent(userId, k -> new ArrayList<>()).add(todoId);
    }

    public List<Integer> get(Integer userId) {
        if (userIdToTodoId.containsKey(userId)) {
            return userIdToTodoId.get(userId);
        }
        throw new RuntimeException("user id not found");
    }

}
