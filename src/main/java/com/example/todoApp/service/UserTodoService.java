package main.java.com.example.todoApp.service;

import main.java.com.example.todoApp.repository.UserTodoRepository;

public class UserTodoService {
    private UserTodoRepository userTodoRepository;

    public UserTodoService() {
        this.userTodoRepository = new UserTodoRepository();
    }

    public void add(Integer userId, Integer todoId) {
        userTodoRepository.add(userId, todoId);
    }
}
