package dev.lucasgontijo.boardgamestore.catalog.controller;

import dev.lucasgontijo.boardgamestore.catalog.domain.Category;
import dev.lucasgontijo.boardgamestore.catalog.domain.CategoryId;
import dev.lucasgontijo.boardgamestore.catalog.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryRepresentation>> list() {
        List<Category> all = categoryService.findAll();

        return ResponseEntity.ok(all.stream()
                .map(CategoryRepresentationMapper::toRepresentation)
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<CategoryRepresentation> create(@RequestBody CategoryRepresentation categoryRepresentation) {
        Category category = CategoryRepresentationMapper.toDomain(categoryRepresentation);

        Category createdCategory = categoryService.create(category);

        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryRepresentationMapper.toRepresentation(createdCategory));
    }


    @PutMapping
    public ResponseEntity<CategoryRepresentation> update(@RequestBody CategoryRepresentation categoryRepresentation) {
        Category category = CategoryRepresentationMapper.toDomain(categoryRepresentation);

        Category createdCategory = categoryService.update(category);

        return ResponseEntity.status(HttpStatus.OK)
                .body(CategoryRepresentationMapper.toRepresentation(createdCategory));
    }


    @GetMapping("/{id}")
    public ResponseEntity<CategoryRepresentation> findById(@PathVariable("id") Long id) {
        CategoryId categoryId = new CategoryId(id);

        Category byId = categoryService.findById(categoryId);

        return ResponseEntity.ok(CategoryRepresentationMapper.toRepresentation(byId));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        CategoryId categoryId = new CategoryId(id);

        categoryService.delete(categoryId);

        return ResponseEntity.noContent().build();
    }

}
