package org.whatislove.library.dao;


import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.whatislove.library.models.Person;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;


@Component
public class PersonDAO {

    /*private final EntityManager entityManager;

    @Autowired
    public PersonDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(readOnly = true)
    public void testNPlus1(){
        Session session = entityManager.unwrap(Session.class);

        Set<Person> people = new HashSet<>(
                session.createQuery("SELECT p FROM Person p LEFT JOIN FETCH p.personBooks").getResultList());

        for(Person person : people)
            System.out.println(person.getName() + ": " + person.getPersonBooks());
    }*/
}
