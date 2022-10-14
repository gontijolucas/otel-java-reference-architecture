package dev.lucasgontijo.boardgamestore.catalog.domain;

import dev.lucasgontijo.boardgamestore.commons.validation.OnCreate;
import dev.lucasgontijo.boardgamestore.commons.validation.OnDelete;
import dev.lucasgontijo.boardgamestore.commons.validation.OnGet;
import dev.lucasgontijo.boardgamestore.commons.validation.OnUpdate;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;

public class Product {

    @Null(groups = OnCreate.class)
    @NotEmpty(groups = { OnGet.class, OnUpdate.class, OnDelete.class })
    @Valid
    private ProductId id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    @NotEmpty
    private String sku;

    @NotEmpty
    private String editor;

    @NotNull
    @Positive
    private Integer playerNumber;

    @NotNull
    @Positive
    private Integer playTime;

    private Category category;

    public ProductId getId() {
        return id;
    }

    public void setId(ProductId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public Integer getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(Integer playerNumber) {
        this.playerNumber = playerNumber;
    }

    public Integer getPlayTime() {
        return playTime;
    }

    public void setPlayTime(Integer playTime) {
        this.playTime = playTime;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
