package org.whatislove.library.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.whatislove.library.models.Book;

import java.util.List;
import java.util.Optional;

@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index(){
        return jdbcTemplate.query("SELECT * FROM book", new Object[]{}, new BeanPropertyRowMapper<>(Book.class));
    }

    public Optional<Book> show(int id){
        return jdbcTemplate.query("SELECT * FROM book WHERE id=?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Book.class)).stream().findAny();
    }

    public List<Book> getPersonBooks(int personId){
        return jdbcTemplate.query("SELECT * FROM book WHERE user_id = ?", new Object[]{personId},
                new BeanPropertyRowMapper<>(Book.class));
    }

    public void save(Book book){
        jdbcTemplate.update("INSERT INTO book(user_id, name, author, year) VALUES(?, ?, ?, ?)",
                book.getUserId(), book.getName(), book.getAuthor(), book.getYear());
    }

    public void update(Book book, int id){
        jdbcTemplate.update("UPDATE book SET user_id=?, name=?, author=?, year=? WHERE id=?",
                book.getUserId(), book.getName(), book.getAuthor(), book.getYear(), id);
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM book WHERE id=?", id);
    }
}
