package main.java.com.example.todoApp.service;

import main.java.com.example.todoApp.model.Task;
import main.java.com.example.todoApp.repository.TaskRepository;

import java.time.LocalDateTime;

public class TaskService {
    private TaskRepository taskRepository;

    public TaskService() {
        this.taskRepository = new TaskRepository();
    }

    public Task addTask(String description, LocalDateTime startsOn, LocalDateTime deadLine) {
        Task task = new Task(description, startsOn, deadLine);
        taskRepository.add(task);
        return task;
    }

    public Task removeTask(Integer taskId) {
        return taskRepository.remove(taskId);
    }

    public void completeTask(Integer taskId) {
        Task task = taskRepository.get(taskId);
        task.complete();
    }

    public Task updateDescription(Integer taskId, String description) {
        Task task = taskRepository.get(taskId);
        task.setDescription(description);
        taskRepository.add(task);
        return task;
    }

    public Task updateStartsOn(Integer taskId, LocalDateTime startsOn) {
        Task task = taskRepository.get(taskId);
        task.setStartsOn(startsOn);
        taskRepository.add(task);
        return task;
    }

    public Task updateDeadline(Integer taskId, LocalDateTime deadLine) {
        Task task = taskRepository.get(taskId);
        task.setDeadLine(deadLine);
        taskRepository.add(task);
        return task;
    }

}
