package main.java.com.example.todoApp.service;

import main.java.com.example.todoApp.model.Task;
import main.java.com.example.todoApp.model.Todo;

import java.time.LocalDateTime;

public class TodoClientService {
    private TodoService todoService;
    private UserService userService;
    private TaskService taskService;
    private UserTodoService userTodoService;

    public TodoClientService() {
        this.todoService = new TodoService();
        this.userService = new UserService();
        this.taskService = new TaskService();
        this.userTodoService = new UserTodoService();
    }

    public void createTodo(Integer userId, String TodoName, String description) {
        if (!userService.userExists(userId)) {
            throw new RuntimeException("user id : " + userId + " does not exist");
        }
        Todo todo = this.todoService.addTodo(TodoName, description);
        this.userTodoService.add(userId, todo.getId());
    }

    public void createUser(String name) {
        this.userService.addUser(name);
    }

    public void createTask(Integer todoId, String description, LocalDateTime startsOn, LocalDateTime deadLine) {
        if (!todoService.todoExists(todoId)) {
            throw new RuntimeException("todo id : " + todoId +" does not exist");
        }
        Task task = this.taskService.addTask(description, startsOn, deadLine);
        Todo todo = this.todoService.getTodo(todoId);
        todo.addTask(task);
    }
}
