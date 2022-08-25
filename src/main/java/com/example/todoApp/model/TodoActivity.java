package main.java.com.example.todoApp.model;

import java.time.LocalDateTime;

public class TodoActivity {

    private Integer id;
    private TodoActivityAction action;
    private Integer todoId;
    private String todoDescription;
    private Integer taskId;
    private LocalDateTime time;
    private TaskStatus taskStatus;
    private String taskDescription;
    private static Integer counter = 0;

    public TodoActivity(TodoActivityAction action, Integer todoId, String todoDescription, Integer taskId, LocalDateTime time, TaskStatus taskStatus, String taskDescription) {
        this.id = ++counter;
        this.action = action;
        this.todoId = todoId;
        this.todoDescription = todoDescription;
        this.taskId = taskId;
        this.time = time;
        this.taskStatus = taskStatus;
        this.taskDescription = taskDescription;
    }

    public Integer getId() {
        return this.id;
    }

    public TodoActivityAction getAction() {
        return this.action;
    }

    public void setAction(TodoActivityAction action) {
        this.action = action;
    }

    public Integer getTodoId() {
        return this.todoId;
    }

    public void setTodoId(Integer todoId) {
        this.todoId = todoId;
    }

    public Integer getTaskId() {
        return this.taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskDescription() {
        return this.taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTodoDescription() {
        return todoDescription;
    }

    public void setTodoDescription(String todoDescription) {
        this.todoDescription = todoDescription;
    }
}
