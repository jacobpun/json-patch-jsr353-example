package com.pk.jsonpatch.jsonpatchexample.model;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.validation.annotation.Validated;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Validated
@Getter
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class Book {
    @NotBlank 
    final private String isbn;
    
    @NotBlank 
    final private String name;
    
    @Setter 
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MMM-dd HH:mm:ss z")
    private LocalDate publishedDate;
    
    @Setter private List<Author> authors;
}