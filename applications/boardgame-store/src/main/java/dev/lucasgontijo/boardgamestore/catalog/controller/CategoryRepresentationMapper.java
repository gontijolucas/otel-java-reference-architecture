package dev.lucasgontijo.boardgamestore.catalog.controller;

import dev.lucasgontijo.boardgamestore.catalog.domain.Category;
import dev.lucasgontijo.boardgamestore.catalog.domain.CategoryId;

public class CategoryRepresentationMapper {


    public static Category toDomain(CategoryRepresentation categoryRepresentation) {
        return new Category(
                new CategoryId(categoryRepresentation.id()),
                categoryRepresentation.name()
        );
    }

    public static CategoryRepresentation toRepresentation(Category category) {
        return new CategoryRepresentation(
                category.getId().getValue(),
                category.getName()
        );
    }






}
