package dev.lucasgontijo.boardgamestore.catalog.repository;

import dev.lucasgontijo.boardgamestore.catalog.domain.Category;
import dev.lucasgontijo.boardgamestore.catalog.domain.CategoryId;

import java.util.List;
import java.util.Optional;

public interface CategoryRepositoryAPI {

    List<Category> findAll();

    Category save(Category category);

    void delete(Category category);

    Optional<Category> findById(CategoryId categoryId);


}
