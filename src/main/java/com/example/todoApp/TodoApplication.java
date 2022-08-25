package main.java.com.example.todoApp;

import main.java.com.example.todoApp.model.Task;
import main.java.com.example.todoApp.model.Todo;
import main.java.com.example.todoApp.model.User;
import main.java.com.example.todoApp.service.TodoClientService;

import java.time.LocalDateTime;
import java.time.Month;

public class TodoApplication {
    // create a user
    // create a todo list for the user
    // create tasks for that todolist
    // remove a task
    public static void main(String[] args) {
        TodoClientService todoClientService = new TodoClientService();
        LocalDateTime futureDateInNovemeber2022 = LocalDateTime.of(2022, Month.NOVEMBER, 22, 20, 10);
        LocalDateTime futureDateInDecember2022 = LocalDateTime.of(2022, Month.DECEMBER, 22, 20, 10);
        User user = todoClientService.createUser("John");
        Todo todo = todoClientService.createTodo(user.getId(), "Daily Task", "every day tasks");
        Task task = todoClientService.createTask(todo.getId(), "file tax", LocalDateTime.now(), LocalDateTime.now());
        Task futureTask = todoClientService.createTask(todo.getId(), "Deploy in production", futureDateInNovemeber2022, futureDateInDecember2022);
        todoClientService.printTodoList(todo.getId());
        todoClientService.completeTask(task.getId());
        boolean taskDeletedSuccessFully = todoClientService.removeTask(task.getId());
        System.out.println("task deletion successful : " + taskDeletedSuccessFully);
        todoClientService.printTodoList(todo.getId());
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
