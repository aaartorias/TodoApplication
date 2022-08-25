package main.java.com.example.todoApp.repository;

import java.util.HashMap;
import java.util.Map;

public class TaskToTodoRepository {
    Map<Integer, Integer> taskIdToTodoId;

    public TaskToTodoRepository() {
        this.taskIdToTodoId = new HashMap<>();
    }

    public void add(Integer taskId, Integer todoId) {
        this.taskIdToTodoId.put(taskId, todoId);
    }

    public Integer get(Integer taskId) {
        if (!this.contains(taskId)) {
            throw new RuntimeException("task id : " + taskId + " does not exist");
        }
        return this.taskIdToTodoId.get(taskId);
    }

    public boolean contains(Integer taskId) {
        return this.taskIdToTodoId.containsKey(taskId);
    }
}
