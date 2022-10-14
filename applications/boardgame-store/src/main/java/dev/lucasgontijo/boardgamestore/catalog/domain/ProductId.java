package dev.lucasgontijo.boardgamestore.catalog.domain;

import javax.validation.constraints.NotEmpty;

public class ProductId {

    @NotEmpty
    private Long value;

    public ProductId() {
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
