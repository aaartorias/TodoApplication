package main.java.com.example.todoApp.service;

import main.java.com.example.todoApp.model.Task;
import main.java.com.example.todoApp.model.Todo;
import main.java.com.example.todoApp.repository.TaskToTodoRepository;
import main.java.com.example.todoApp.repository.TodoRepository;

import java.util.List;

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

    public Todo removeTask(Task task) {
        Integer todoId = getTodoIdForTaskId(task.getId());
        Todo todo = this.todoRepository.get(todoId);
        todo.removeTask(task);
        return todo;
    }

    public Integer getTodoIdForTaskId(Integer taskId) {
        return this.taskToTodoRepository.get(taskId);
    }

    public void addTaskToTodo(Integer taskId, Integer todoId) {
        this.taskToTodoRepository.add(taskId, todoId);
    }

    public void printCurrentTasks(Integer todoId) {
        Todo todo = todoRepository.get(todoId);
        List<Task> tasks = todo.getTasks();
        if (tasks.isEmpty()) {
            System.out.println("Todo List is empty");
        } else {
            for (Task task : tasks) {
                if (!task.isInFuture()) {
                    System.out.println("Task Id : " + task.getId() + " Description : " + task.getDescription()
                            + " Start Time : " + task.getStartsOn() + " Deadline : " + task.getDeadLine());
                }
            }
        }
    }
}
