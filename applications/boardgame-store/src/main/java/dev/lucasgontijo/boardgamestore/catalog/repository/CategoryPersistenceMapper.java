package dev.lucasgontijo.boardgamestore.catalog.repository;

import dev.lucasgontijo.boardgamestore.catalog.domain.Category;
import dev.lucasgontijo.boardgamestore.catalog.domain.CategoryEntity;
import dev.lucasgontijo.boardgamestore.catalog.domain.CategoryId;

class CategoryPersistenceMapper {

    public static Category toDomain(CategoryEntity entity) {
        Category category = new Category();
        category.setId(new CategoryId(entity.getId()));
        category.setName(entity.getName());
        return category;
    }

    public static CategoryEntity toEntity(Category category) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(category.getId() == null ? null : category.getId().getValue());
        categoryEntity.setName(categoryEntity.getName());
        return categoryEntity;
    }
}
