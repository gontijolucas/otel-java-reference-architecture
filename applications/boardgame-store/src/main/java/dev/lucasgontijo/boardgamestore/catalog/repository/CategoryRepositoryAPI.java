package dev.lucasgontijo.boardgamestore.catalog.repository;

import dev.lucasgontijo.boardgamestore.catalog.domain.Category;

import java.util.List;

public interface CategoryRepositoryAPI {

    List<Category> findAll();

    Category save(Category category);

    void delete(Category category);
}
