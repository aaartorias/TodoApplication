package main.java.com.example.todoApp.service;

import main.java.com.example.todoApp.model.User;
import main.java.com.example.todoApp.repository.UserRepository;

public class UserService {
    private UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    public void addUser(String name) {
        User user = new User(name);
        userRepository.add(user);
    }

    public boolean userExists(Integer userId) {
        return userRepository.contains(userId);
    }
}
