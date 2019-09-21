package com.pk.jsonpatch.jsonpatchexample.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookBuilder {
    private String name;
    private String isbn;
    private LocalDate publishedOnDate;
    private List<Author> authors = new ArrayList<>();
    
    private BookBuilder() {}

    public static BookBuilder aBook() {
        return new BookBuilder();
    }

    public BookBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public BookBuilder withIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public BookBuilder authoredBy(String authorName) {
        this.authors.add(new Author(authorName));
        return this;
    }

    public BookBuilder publishedOn(LocalDate date) {
        this.publishedOnDate = date;
        return this;
    }

    public BookBuilder and() {
        return this;
    }

    public Book build() {
        Book book = new Book(isbn, name);
        book.setAuthors(authors);
        book.setPublishedDate(publishedOnDate);
        return book;
    }
}