package dev.lucasgontijo.boardgamestore.catalog.repository;

import dev.lucasgontijo.boardgamestore.catalog.domain.Category;
import dev.lucasgontijo.boardgamestore.catalog.domain.CategoryEntity;

import java.util.List;
import java.util.stream.Collectors;

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
}
