package com.pk.jsonpatch.jsonpatchexample.model;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class Author {
    @NotNull
    private final String name;
}