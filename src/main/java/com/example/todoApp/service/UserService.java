package main.java.com.example.todoApp.service;

import main.java.com.example.todoApp.model.User;
import main.java.com.example.todoApp.repository.UserRepository;

public class UserService {
    private UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    public User addUser(String name) {
        User user = new User(name);
        this.userRepository.add(user);
        return user;
    }

    public boolean userExists(Integer userId) {
        return this.userRepository.contains(userId);
    }
}
