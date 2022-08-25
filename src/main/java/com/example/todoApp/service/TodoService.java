package main.java.com.example.todoApp.service;

import main.java.com.example.todoApp.model.Todo;
import main.java.com.example.todoApp.repository.TodoRepository;

public class TodoService {
    private TodoRepository todoRepository;
    public TodoService() {
        this.todoRepository = new TodoRepository();
    }
    public void createTodo() {
        Todo todo = null;
        todoRepository.add(todo);
    }
}
