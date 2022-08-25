package main.java.com.example.todoApp.repository;

import main.java.com.example.todoApp.model.Task;

import java.util.HashMap;
import java.util.Map;

public class TaskRepository {
    private Map<Integer, Task> taskIdToTask;

    public TaskRepository() {
        this.taskIdToTask = new HashMap<>();
    }

    public Task get(Integer id) {
        if (this.taskIdToTask.containsKey(id)) {
            return this.taskIdToTask.get(id);
        }
        throw new RuntimeException("Task not found");
    }

    public void add(Task task) {
        this.taskIdToTask.put(task.getId(), task);
    }
}
