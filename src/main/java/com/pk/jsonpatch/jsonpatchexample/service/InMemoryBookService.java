package com.pk.jsonpatch.jsonpatchexample.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.pk.jsonpatch.jsonpatchexample.model.Book;

import org.springframework.stereotype.Service;

import static com.pk.jsonpatch.jsonpatchexample.model.BookBuilder.aBook;

/**
 * Simple In Memory service for books
 */
@Service
public class InMemoryBookService implements BookService {

    private Map<String, Book> books = new HashMap<>();

    public InMemoryBookService() {
        Book hitRefresh = aBook()
                            .withName("Hit Refresh")
                            .withIsbn("1")
                            .authoredBy("Satya Nadella")
                            .and()
                            .publishedOn(LocalDate.now())
                            .build();
        this.books.put(hitRefresh.getIsbn(), hitRefresh);
    }

    @Override
    public Book getByIsbn(String isbn) {
        return books.get(isbn);
    }

    @Override
    public void update(String isbn, Book book) {
        books.put(isbn, book);
    }
}