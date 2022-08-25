package main.java.com.example.todoApp;

import main.java.com.example.todoApp.model.Task;
import main.java.com.example.todoApp.model.Todo;
import main.java.com.example.todoApp.model.User;
import main.java.com.example.todoApp.service.TodoClientService;

import java.time.LocalDateTime;

public class TodoApplication {
    // create a user
    // create a todo list for the user
    // create tasks for that todolist
    // remove a task
    public static void main(String[] args) {
        TodoClientService todoClientService = new TodoClientService();
        User user = todoClientService.createUser("John");
        Todo todo = todoClientService.createTodo(user.getId(), "Daily Task", "every day tasks");
        Task task = todoClientService.createTask(todo.getId(), "file tax", LocalDateTime.now(), LocalDateTime.now());
        todoClientService.completeTask(task.getId());
        boolean taskDeletedSuccessFully = todoClientService.removeTask(task.getId());
        System.out.println("task deletion successful : " + taskDeletedSuccessFully);
        // update task using getter and setters

    }

    private void addTask() {

    }

    private void getTask() {

    }

    private void modifyTask() {
        // making the assumption here about the flow:
        // we have already fetched the task and made modifications to the task using setters.
        // in modifyTask(), we are asking to save it in the todo-list and the in-memory data store

    }

    private void removeTask(Integer taskId) {

    }

    private void listTasks() {

    }

    private void getStatistics() {

    }

    private void getActivityLog() {

    }
}
