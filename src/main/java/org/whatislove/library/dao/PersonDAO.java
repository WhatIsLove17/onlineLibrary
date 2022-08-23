package org.whatislove.library.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.whatislove.library.models.Person;

import java.util.List;
import java.util.Optional;


@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index(){
        return jdbcTemplate.query("SELECT * FROM people", new BeanPropertyRowMapper<>(Person.class));
    }

    public Optional<Person> show(String email){
        return jdbcTemplate.query("SELECT * FROM people WHERE email=?", new Object[]{email},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    public Person show(int id){
        return jdbcTemplate.query("SELECT * FROM people WHERE id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }

    public void save(Person person){
        jdbcTemplate.update("INSERT INTO people(name, age, email, address) VALUES (?, ?, ?, ?)", person.getName(),
                person.getAge(), person.getEmail(), person.getAddress());
    }

    public void update(Person updatedPerson, int id){
        jdbcTemplate.update("UPDATE people SET id=?, name=?, age=?, email=?, address=? WHERE id=?",
                updatedPerson.getId(), updatedPerson.getName(), updatedPerson.getAge(), updatedPerson.getEmail(),
                updatedPerson.getAddress(), id);
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM people WHERE id=?", id);
    }
}
