package main.java.com.example.todoApp.model;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Date;

public class Task {
    private Integer id;
    private String description;
    private LocalDateTime startsOn;
    private LocalDateTime deadLine;
    private static Integer counter = 0;
    private TaskStatus status;

    public Task(String description, LocalDateTime startsOn, LocalDateTime deadLine) {
        this.id = ++counter;
        this.description = description;
        this.startsOn = startsOn;
        this.deadLine = deadLine;
        this.status = this.calculateStatus();
    }

    private TaskStatus calculateStatus() {
        if (this.startsOn.isAfter(LocalDateTime.now())) {
            return TaskStatus.IN_FUTURE;
        }
        return TaskStatus.STARTED;
    }

    public Integer getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDeadLine() {
        return this.deadLine;
    }

    public void setDeadLine(LocalDateTime deadLine) {
        this.deadLine = deadLine;
    }

    public LocalDateTime getStartsOn() {
        return this.startsOn;
    }

    public void setStartsOn(LocalDateTime startsOn) {
        this.startsOn = startsOn;
    }

    public TaskStatus getStatus() {
        return this.status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
