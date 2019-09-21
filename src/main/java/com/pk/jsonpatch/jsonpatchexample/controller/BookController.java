package com.pk.jsonpatch.jsonpatchexample.controller;

import javax.json.JsonPatch;
import javax.json.JsonStructure;
import javax.validation.Valid;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pk.jsonpatch.jsonpatchexample.model.Book;
import com.pk.jsonpatch.jsonpatchexample.service.BookService;

/**
 * BookController
 */
@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private ObjectMapper mapper;

    @GetMapping("{isbn}")
    public Book getById(@PathVariable String isbn) {
        return bookService.getByIsbn(isbn);
    }
    
    @PatchMapping(path = "{isbn}", consumes = "application/json-patch+json")
    @Valid
    public Book patchBook(@PathVariable String isbn, @RequestBody JsonPatch changes) {
        // get book object for given isbn
        Book book = bookService.getByIsbn(isbn);

        // convert to json-p structure so that it can be patched
        JsonStructure converted = mapper.convertValue(book, JsonStructure.class);

        // perform patch
        JsonStructure patched = changes.apply(converted);

        // convert back to Book object
        Book patchedBook = mapper.convertValue(patched, Book.class);

        // update the data store
        this.bookService.update(isbn, patchedBook);

        // return patched book
        return patchedBook;
    }
}