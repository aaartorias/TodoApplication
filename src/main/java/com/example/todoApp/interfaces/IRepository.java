package main.java.com.example.todoApp.interfaces;

public interface IRepository<T, V> {
    void add (V obj);
    V get(T key);
    boolean contains(T key);
}
