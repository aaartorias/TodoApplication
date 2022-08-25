package main.java.com.example.todoApp.service;

import main.java.com.example.todoApp.model.*;
import main.java.com.example.todoApp.repository.TodoActivityRepository;
import main.java.com.example.todoApp.repository.TodoToActivityRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TodoActivityService {
    private TodoActivityRepository todoActivityRepository;
    private TodoToActivityRepository todoToActivityRepository;

    public TodoActivityService() {
        this.todoActivityRepository = todoActivityRepository;
        this.todoToActivityRepository = todoToActivityRepository;
    }

    public void todoCreated(Todo todo) {
        TodoActivity todoActivity = new TodoActivity(TodoActivityAction.CREATED, todo.getId(), todo.getDescription(), null, LocalDateTime.now(), null, null);
        addActivity(todoActivity);
    }

    public void todoTaskAdded(Todo todo, Task task) {
        TodoActivity todoActivity = new TodoActivity(TodoActivityAction.TASK_ADDED, todo.getId(), todo.getDescription(), task.getId(), LocalDateTime.now(), task.getStatus(), task.getDescription());
        addActivity(todoActivity);
    }

    public void todoTaskUpdated(Todo todo, Task task) {
        TodoActivity todoActivity = new TodoActivity(TodoActivityAction.TASK_MODIFIED, todo.getId(), todo.getDescription(), task.getId(), LocalDateTime.now(), task.getStatus(), task.getDescription());
        addActivity(todoActivity);
    }

    public void todoTaskRemoved(Todo todo, Task task) {
        TodoActivity todoActivity = new TodoActivity(TodoActivityAction.TASK_REMOVED, todo.getId(), todo.getDescription(), task.getId(), LocalDateTime.now(), task.getStatus(), task.getDescription());
        addActivity(todoActivity);
    }

    private void addActivity(TodoActivity todoActivity) {
        todoActivityRepository.add(todoActivity);
        todoToActivityRepository.add(todoActivity.getTodoId(), todoActivity.getId());
    }

    public List<TodoActivity> getActivtyForTodoBetween(Integer todoId, LocalDateTime start, LocalDateTime end) {
        List<TodoActivity> activities = new ArrayList<>();
        List<Integer> activityIds = todoToActivityRepository.get(todoId);
        for (Integer activityId : activityIds) {
            TodoActivity activity = todoActivityRepository.get(activityId);
            if (activity.getTime().isAfter(start) && activity.getTime().isBefore(end)) {
                activities.add(activity);
            }
        }
        return activities;
    }
}
