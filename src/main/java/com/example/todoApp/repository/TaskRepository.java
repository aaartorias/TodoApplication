package main.java.com.example.todoApp.repository;

import main.java.com.example.todoApp.interfaces.IRepository;
import main.java.com.example.todoApp.model.Task;

import java.util.HashMap;
import java.util.Map;

public class TaskRepository implements IRepository<Integer, Task> {
    private Map<Integer, Task> taskIdToTask;

    public TaskRepository() {
        this.taskIdToTask = new HashMap<>();
    }

    @Override
    public Task get(Integer key) {
        if (this.taskIdToTask.containsKey(key)) {
            return this.taskIdToTask.get(key);
        }
        throw new RuntimeException("Task not found");
    }

    @Override
    public void add(Task task) {
        this.taskIdToTask.put(task.getId(), task);
    }

    @Override
    public boolean contains(Integer key) {
        return this.taskIdToTask.containsKey(key);
    }

    public Task remove(Integer taskId) {
        return this.taskIdToTask.remove(taskId);
    }
}
