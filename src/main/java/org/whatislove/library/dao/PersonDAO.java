package org.whatislove.library.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.whatislove.library.models.Person;

import java.util.List;

/*

@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;
    private final SessionFactory sessionFactory;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate, SessionFactory sessionFactory) {
        this.jdbcTemplate = jdbcTemplate;
        this.sessionFactory = sessionFactory;
    }


    @Transactional(readOnly = true)
    public List<Person> index() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("SELECT p FROM Person p WHERE p.id <> 0", Person.class).getResultList();
    }

    @Transactional(readOnly = true)
    public Person show(String email) {
        Session session = sessionFactory.getCurrentSession();
        return null;
    }

    @Transactional(readOnly = true)
    public Person show(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT p FROM Person p WHERE p.id=:id", Person.class);
        query.setParameter("id", id);
        return (Person) query.getSingleResult();
    }

    @Transactional
    public void save(Person person) {
        Session session = sessionFactory.getCurrentSession();
        */
/*Query query = session.createQuery("")
        jdbcTemplate.update("INSERT INTO Person(name, year, email, address) VALUES (?, ?, ?, ?)", person.getName(),
                person.getYear(), person.getEmail(), person.getAddress());*//*

    }

    public void update(Person updatedPerson, int id) {
        jdbcTemplate.update("UPDATE Person SET name=?, year=?, email=?, address=? WHERE id=?",
                updatedPerson.getName(), updatedPerson.getYear(), updatedPerson.getEmail(),
                updatedPerson.getAddress(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
    }
}
*/
