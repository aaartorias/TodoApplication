package main.java.com.example.todoApp.model;

public class User {
    private Integer id;
    private String name;
    private static Integer counter = 0;
    // you can add other information like email, phone number etc.
    // but id and name works for our use case

    public User(String name) {
        this.id = ++counter;
        this.name = name;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
