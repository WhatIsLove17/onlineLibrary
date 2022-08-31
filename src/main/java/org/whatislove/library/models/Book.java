package org.whatislove.library.models;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import javax.persistence.*;


@Entity
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "name")
    @Size(min = 1, max = 50)
    private String name;

    @Column(name = "author")
    @Size(min = 2, max = 50)
    private String author;

    @Column(name = "year")
    @Min(value = 1900)
    private int year;

    public Book(int user_id, String name, String author, int year) {
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
