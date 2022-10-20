package dev.lucasgontijo.boardgamestore.catalog.services;

import dev.lucasgontijo.boardgamestore.catalog.domain.Category;
import dev.lucasgontijo.boardgamestore.catalog.repository.CategoryRepositoryAPI;
import dev.lucasgontijo.boardgamestore.commons.validation.OnCreate;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Validated
public class CatalogService {

    private CategoryRepositoryAPI categoryRepository;

    public CatalogService(CategoryRepositoryAPI categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Validated(OnCreate.class)
    public Category create(@Valid Category category) {
        return categoryRepository.save(category);
    }

g}
