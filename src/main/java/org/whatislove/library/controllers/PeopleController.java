package org.whatislove.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.whatislove.library.dao.BookDAO;
import org.whatislove.library.dao.PersonDAO;
import org.whatislove.library.models.Person;
import org.whatislove.library.util.PersonValidator;

import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PersonDAO personDAO;
    private final BookDAO bookDAO;
    private final PersonValidator personValidator;

    @Autowired
    public PeopleController(PersonDAO personDAO, BookDAO bookDAO, PersonValidator personValidator) {
        this.personDAO = personDAO;
        this.bookDAO = bookDAO;
        this.personValidator = personValidator;
    }

    @GetMapping
    public String index(Model model){
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personDAO.show(id));
        model.addAttribute("books", bookDAO.getPersonBooks(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("person", new Person());
        return "people/new";
    }

    @PostMapping()
    public String createPerson(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult){
        personValidator.validate(person, bindingResult);
        if (bindingResult.hasErrors())
            return "people/new";
        personDAO.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personDAO.show(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String updatePerson(@PathVariable("id") int id, @ModelAttribute("person") @Valid Person person,
                               BindingResult bindingResult){
        personValidator.validate(person, bindingResult);
        if (bindingResult.hasErrors())
            return "people/edit";
        personDAO.update(person, id);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable("id") int id){
        personDAO.delete(id);
        return "redirect:/people";
    }
}
