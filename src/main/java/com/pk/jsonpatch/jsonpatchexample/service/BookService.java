package com.pk.jsonpatch.jsonpatchexample.service;

import com.pk.jsonpatch.jsonpatchexample.model.Book;

public interface BookService {
    Book getByIsbn(String isbn);
    void update(String isbn, Book book);
}
