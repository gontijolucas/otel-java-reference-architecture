package dev.lucasgontijo.boardgamestore.catalog.repository;

import dev.lucasgontijo.boardgamestore.catalog.domain.Category;
import dev.lucasgontijo.boardgamestore.catalog.domain.CategoryEntity;
import dev.lucasgontijo.boardgamestore.catalog.domain.CategoryId;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CategoryRepository implements CategoryRepositoryAPI {

    private CategoryRepositoryJPA categoryRepositoryJPA;

    public CategoryRepository(CategoryRepositoryJPA categoryRepositoryJPA) {
        this.categoryRepositoryJPA = categoryRepositoryJPA;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepositoryJPA.findAll().stream().map(CategoryPersistenceMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Category save(Category category) {
        CategoryEntity entity = CategoryPersistenceMapper.toEntity(category);
        CategoryEntity persistedCategoryEntity = categoryRepositoryJPA.save(entity);

        return CategoryPersistenceMapper.toDomain(persistedCategoryEntity);
    }

    @Override
    public void delete(Category category) {
        categoryRepositoryJPA.deleteById(category.getId().getValue());
    }

    @Override
    public Optional<Category> findById(CategoryId categoryId) {

        Objects.requireNonNull(categoryId, "Category 'id' cannot be null");
        Objects.requireNonNull(categoryId.getValue(), "Category 'id' value cannot be null");

        return categoryRepositoryJPA.findById(categoryId.getValue())
                .map(CategoryPersistenceMapper::toDomain);
    }
}
