package main.java.com.example.todoApp.service;

import main.java.com.example.todoApp.model.*;

import java.time.LocalDateTime;
import java.util.List;

public class TodoClientService {
    private TodoService todoService;
    private UserService userService;
    private TaskService taskService;
    private UserTodoService userTodoService;
    private TodoActivityService todoActivityService;

    public TodoClientService() {
        this.todoService = new TodoService();
        this.userService = new UserService();
        this.taskService = new TaskService();
        this.userTodoService = new UserTodoService();
        this.todoActivityService = new TodoActivityService();
    }

    public Todo createTodo(Integer userId, String TodoName, String description) {
        if (!userService.userExists(userId)) {
            throw new RuntimeException("user id : " + userId + " does not exist");
        }
        Todo todo = this.todoService.addTodo(TodoName, description);
        this.todoActivityService.todoCreated(todo);
        this.userTodoService.add(userId, todo.getId());
        return todo;
    }

    public User createUser(String name) {
        return this.userService.addUser(name);
    }

    public Task createTask(Integer todoId, String description, LocalDateTime startsOn, LocalDateTime deadLine) {
        if (!todoService.todoExists(todoId)) {
            throw new RuntimeException("todo id : " + todoId +" does not exist");
        }
        Task task = this.taskService.addTask(description, startsOn, deadLine);
        Todo todo = this.todoService.getTodo(todoId);
        this.todoService.addTaskToTodo(task.getId(), todo.getId());
        todo.addTask(task);
        this.todoActivityService.todoTaskAdded(todo, task);
        return task;
    }

    public boolean removeTask(Integer taskId) {
        Task task = taskService.removeTask(taskId);
        if (task != null) {
            Todo todo = todoService.removeTask(task);
            this.todoActivityService.todoTaskAdded(todo, task);
            return true;
        }
        return false;
    }

    public void completeTask(Integer taskId) {
        taskService.completeTask(taskId);
        removeTask(taskId);
    }

    public void printTodoList(Integer todoId) {
        todoService.printCurrentTasks(todoId);
    }

    public void printActivityForTodoBetweenTime(Integer todoId, LocalDateTime start, LocalDateTime end) {
         List<TodoActivity> activities = todoActivityService.getActivtyForTodoBetween(todoId, start, end);
         for (TodoActivity activity : activities) {
             System.out.println("Activity Id : " + activity.getId() + " Todo Id : " + activity.getTodoId() +
                     "Todo Description : " + activity.getTodoDescription() + " Task Id : " + activity.getTaskId()
                     + " Task Status : " + activity.getTaskStatus() + "Task Description "
                     + activity.getTaskDescription() + " Action : " + activity.getAction());
         }
    }

    public void updateDescription(Integer taskId, String description) {
        Task task = taskService.updateDescription(taskId, description);
        updateTodoActivity(taskId, task);
    }

    private void updateTodoActivity(Integer taskId, Task task) {
        Integer todoId = this.todoService.getTodoIdForTaskId(taskId);
        Todo todo = this.todoService.getTodo(todoId);
        this.todoActivityService.todoTaskUpdated(todo, task);
    }

    public void updateStartsOn(Integer taskId, LocalDateTime startsOn) {
        Task task = taskService.updateStartsOn(taskId, startsOn);
        updateTodoActivity(taskId, task);
    }

    public void updateDeadLine(Integer taskId, LocalDateTime deadLine) {
        Task task = taskService.updateDeadline(taskId, deadLine);
        updateTodoActivity(taskId, task);
    }


}
