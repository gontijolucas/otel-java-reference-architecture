package dev.lucasgontijo.boardgamestore.catalog.domain;

import javax.validation.constraints.NotNull;

public class CategoryId {

    @NotNull
    private Long value;

    public CategoryId() {

    }

    public CategoryId(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
