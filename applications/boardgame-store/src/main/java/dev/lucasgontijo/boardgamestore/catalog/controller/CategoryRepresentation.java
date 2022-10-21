package dev.lucasgontijo.boardgamestore.catalog.controller;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
record CategoryRepresentation(
        Long id,
        String name
){}

