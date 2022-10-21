package dev.lucasgontijo.boardgamestore.catalog.services;

import dev.lucasgontijo.boardgamestore.catalog.domain.Category;
import dev.lucasgontijo.boardgamestore.catalog.domain.CategoryId;
import dev.lucasgontijo.boardgamestore.catalog.domain.errors.CategoryNotFoundException;
import dev.lucasgontijo.boardgamestore.catalog.repository.CategoryRepositoryAPI;
import dev.lucasgontijo.boardgamestore.commons.validation.OnCreate;
import dev.lucasgontijo.boardgamestore.commons.validation.OnDelete;
import dev.lucasgontijo.boardgamestore.commons.validation.OnGet;
import dev.lucasgontijo.boardgamestore.commons.validation.OnUpdate;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class CategoryService {

    private final CategoryRepositoryAPI categoryRepository;

    public CategoryService(CategoryRepositoryAPI categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Validated(OnCreate.class)
    public Category create(@Valid Category category) {
        return categoryRepository.save(category);
    }

    @Validated(OnUpdate.class)
    public Category update(@Valid Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }


    @Validated(OnGet.class)
    public Category findById(@Validated CategoryId categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(()-> new CategoryNotFoundException(
                        String.format("Categoria %d não foi encontrada", categoryId.getValue())
                ));
    }

    @Validated(OnDelete.class)
    public void delete(@Validated CategoryId categoryId) {
        //TODO validar se categoria já tem produto
        categoryRepository.delete(categoryId);
    }
}
