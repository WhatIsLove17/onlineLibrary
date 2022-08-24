package org.whatislove.library.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.whatislove.library.dao.PersonDAO;
import org.whatislove.library.models.Person;

import java.util.Optional;

@Component
public class PersonValidator implements Validator {
    PersonDAO personDAO;

    @Autowired
    public PersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        Optional<Person> recievedPerson = personDAO.show(person.getEmail());
        if (recievedPerson.isPresent())
            if (recievedPerson.get().getId() != person.getId())
                errors.rejectValue("email", "", "This email has already registered");
    }
}
