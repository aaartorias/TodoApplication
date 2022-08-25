package main.java.com.example.todoApp.service;

import main.java.com.example.todoApp.model.Todo;
import main.java.com.example.todoApp.repository.TodoRepository;

public class TodoService {
    private TodoRepository todoRepository;

    public TodoService() {
        this.todoRepository = new TodoRepository();
    }
    public Todo addTodo(String name, String description) {
        Todo todo = new Todo(name, description);
        this.todoRepository.add(todo);
        return todo;
    }

    public boolean todoExists(Integer todoId) {
        return this.todoRepository.contains(todoId);
    }

    public Todo getTodo(Integer todoId) {
        return this.todoRepository.get(todoId);
    }
}
