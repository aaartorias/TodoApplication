package main.java.com.example.todoApp.model;

import java.time.LocalDateTime;

public class Task {
    private Integer id;
    private String description;
    private LocalDateTime deadLine;
    private LocalDateTime startsOn;
    private static Integer counter = 0;

    public Task(String description, LocalDateTime deadLine, LocalDateTime startsOn) {
        this.description = description;
        this.deadLine = deadLine;
        this.startsOn = startsOn;
        this.id = ++counter;
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

}
