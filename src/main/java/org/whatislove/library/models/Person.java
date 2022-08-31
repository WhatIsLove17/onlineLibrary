package org.whatislove.library.models;



import jakarta.validation.constraints.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "Person")
public class Person {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty
    @Size(min = 2, max = 30, message = "Name's size should be between 2 and 30 characters")
    @Column(name = "name")
    private String name;

    @NotNull
    @Min(value = 1900, message = "Year should be more than 1900")
    @Column(name = "year")
    private int year;

    @Email(message = "Email should be valid")
    @Column(name = "email")
    private String email;

    @Column(name = "address")
    @Pattern(regexp = "[A-ZА-Я][a-zа-я]+, [A-ZА-Я][a-zа-я]+, \\d{6}", message = "Address should be in this format: Country, City, 123456")
    private String address;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST)
    private List<Book> personBooks;

    public Person(){}

    public Person(String name, int year, String email, String address) {
        this.name = name;
        this.year = year;
        this.email = email;
        this.address = address;
    }

    public List<Book> getPersonBooks() {
        return personBooks;
    }

    public void setPersonBooks(List<Book> personBooks) {
        this.personBooks = personBooks;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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
