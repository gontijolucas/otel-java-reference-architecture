package dev.lucasgontijo.boardgamestore.catalog.domain.errors;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
