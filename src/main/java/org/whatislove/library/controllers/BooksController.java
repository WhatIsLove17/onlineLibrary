package org.whatislove.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.whatislove.library.dao.BookDAO;
import org.whatislove.library.dao.PersonDAO;
import org.whatislove.library.models.Book;

import javax.validation.Valid;

@Controller
@RequestMapping("/books")
public class BooksController {
    private final BookDAO bookDAO;
    private final PersonDAO personDAO;

    @Autowired
    public BooksController(BookDAO bookDAO, PersonDAO personDAO) {
        this.bookDAO = bookDAO;
        this.personDAO = personDAO;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("books", bookDAO.index());
        return "books/index";
    }

    @GetMapping("/{id}")
    public String show(Model model, @PathVariable("id") int id) {
        Book book = bookDAO.show(id).orElse(null);
        model.addAttribute("book", book);
        model.addAttribute("persons", personDAO.index());
        model.addAttribute("person", personDAO.show(book.getUserId()));
        return "books/show";
    }

    @GetMapping("/new")
    public String newBook(Model model) {
        model.addAttribute("book", new Book());
        return "books/new";
    }

    @PostMapping
    public String createBook(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "books/new";
        book.setUserId(0);
        bookDAO.save(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String editBook(Model model, @PathVariable("id") int id) {
        model.addAttribute("book", bookDAO.show(id).get());
        return "books/edit";
    }

    @PatchMapping("/{id}")
    public String updateBook(@ModelAttribute("book") Book book, @PathVariable("id") int id,
                             BindingResult bindingResult) {
        Book recievedBook = bookDAO.show(id).orElse(null);
        if (book.getName() == null) {
            recievedBook.setUserId(book.getUserId());
            bookDAO.update(recievedBook, id);
        }
        else {
            if (bindingResult.hasErrors())
                return "books/edit";
            book.setUserId(recievedBook.getUserId());
            bookDAO.update(book, id);
        }
        return "redirect:/books/" + book.getId();
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable("id") int id){
        bookDAO.delete(id);
        return "redirect:/books";
    }
}
