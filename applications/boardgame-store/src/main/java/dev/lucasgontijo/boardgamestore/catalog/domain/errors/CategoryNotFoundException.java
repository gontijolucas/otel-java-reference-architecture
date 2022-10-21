package dev.lucasgontijo.boardgamestore.catalog.domain.errors;

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(String message) {
        super(message);
    }
}
