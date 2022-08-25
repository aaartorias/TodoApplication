package main.java.com.example.todoApp.service;

import main.java.com.example.todoApp.model.Task;
import main.java.com.example.todoApp.model.Todo;
import main.java.com.example.todoApp.repository.TaskToTodoRepository;
import main.java.com.example.todoApp.repository.TodoRepository;

public class TodoService {
    private TodoRepository todoRepository;
    private TaskToTodoRepository taskToTodoRepository;

    public TodoService() {
        this.todoRepository = new TodoRepository();
        this.taskToTodoRepository = new TaskToTodoRepository();
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

    public void removeTask(Task task) {
        Integer todoId = this.taskToTodoRepository.get(task.getId());
        Todo todo = this.todoRepository.get(todoId);
        todo.removeTask(task);
    }

    public void addTaskToTodo(Integer taskId, Integer todoId) {
        this.taskToTodoRepository.add(taskId, todoId);
    }
}
