package org.whatislove.library.models;

import javax.validation.constraints.*;

public class Person {
    private int id;
    @NotEmpty
    @Size(min = 2, max = 30, message = "Name's size should be between 2 and 30 characters")
    private String name;

    @NotNull
    @Min(value = 1900, message = "Year should be more than 1900")
    private int year;

    @Email(message = "Email should be valid")
    private String email;

    @Pattern(regexp = "[A-ZА-Я][a-zа-я]+, [A-ZА-Я][a-zа-я]+, \\d{6}", message = "Address should be in this format: Country, City, 123456")
    private String address;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Person(){}

    public Person(int id, String name, int year, String email, String address) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
