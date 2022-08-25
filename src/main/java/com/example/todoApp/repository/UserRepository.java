package main.java.com.example.todoApp.repository;

import main.java.com.example.todoApp.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private Map<Integer, User> userIdToUser;

    public UserRepository() {
        this.userIdToUser = new HashMap<>();
    }

    public User get(Integer id) {
        if (this.userIdToUser.containsKey(id)) {
            return this.userIdToUser.get(id);
        }
        throw new RuntimeException("User not found");
    }

    public void add(User user) {
        this.userIdToUser.put(user.getId(), user);
    }
}
