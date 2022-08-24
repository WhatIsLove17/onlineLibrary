package org.whatislove.library.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Book {
    private int id;
    private int userId;
    @Size(min = 1, max = 50)
    private String name;
    @Size(min = 2, max = 50)
    private String author;
    @Min(value = 1900)
    private int year;

    public Book(int id, int user_id, String name, String author, int year) {
        this.id = id;
        this.userId = user_id;
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int user_id) {
        this.userId = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
