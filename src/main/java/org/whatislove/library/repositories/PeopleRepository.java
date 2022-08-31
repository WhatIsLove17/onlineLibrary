package org.whatislove.library.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.whatislove.library.models.Person;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {

}
