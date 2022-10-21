package dev.lucasgontijo.boardgamestore.catalog.domain.errors;

public class CategoryAlreadyExistsException extends RuntimeException {
    public CategoryAlreadyExistsException(String message) {
        super(message);
    }
}
