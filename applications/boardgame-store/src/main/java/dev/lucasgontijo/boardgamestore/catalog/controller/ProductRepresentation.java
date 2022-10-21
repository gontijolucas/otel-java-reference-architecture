package dev.lucasgontijo.boardgamestore.catalog.controller;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
record ProductRepresentation(
         Long id,
         String name,
         String description,
         String sku,
         String editor,
         Integer playerNumber,
         Integer playTime,
         BigDecimal price,
         Long categoryId
) {
}
