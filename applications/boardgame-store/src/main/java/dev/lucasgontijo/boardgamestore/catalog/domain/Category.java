package dev.lucasgontijo.boardgamestore.catalog.domain;

import dev.lucasgontijo.boardgamestore.commons.validation.OnCreate;
import dev.lucasgontijo.boardgamestore.commons.validation.OnDelete;
import dev.lucasgontijo.boardgamestore.commons.validation.OnGet;
import dev.lucasgontijo.boardgamestore.commons.validation.OnUpdate;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public class Category {

    @Null(groups = OnCreate.class)
    @NotNull(groups = { OnGet.class, OnUpdate.class, OnDelete.class })
    @Valid
    private CategoryId id;

    @NotEmpty
    private String name;

    public Category() {
    }

    public Category(CategoryId id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryId getId() {
        return id;
    }

    public void setId(CategoryId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
