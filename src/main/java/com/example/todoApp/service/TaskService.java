package main.java.com.example.todoApp.service;

import main.java.com.example.todoApp.model.Task;
import main.java.com.example.todoApp.repository.TaskRepository;

public class TaskService {
    private TaskRepository taskRepository;
    public TaskService() {
        this.taskRepository = new TaskRepository();
    }
    public void addUser(String name) {
        Task task = null;
        taskRepository.add(task);
    }
}
