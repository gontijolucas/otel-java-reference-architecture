package dev.lucasgontijo.boardgamestore.catalog.services;

import dev.lucasgontijo.boardgamestore.catalog.domain.Category;
import dev.lucasgontijo.boardgamestore.catalog.domain.CategoryId;
import dev.lucasgontijo.boardgamestore.catalog.domain.Product;
import dev.lucasgontijo.boardgamestore.catalog.domain.ProductId;
import dev.lucasgontijo.boardgamestore.catalog.domain.errors.ProductNotFoundException;
import dev.lucasgontijo.boardgamestore.catalog.repository.CategoryRepository;
import dev.lucasgontijo.boardgamestore.catalog.repository.ProductRepository;
import dev.lucasgontijo.boardgamestore.commons.validation.OnCreate;
import dev.lucasgontijo.boardgamestore.commons.validation.OnGet;
import dev.lucasgontijo.boardgamestore.commons.validation.OnUpdate;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class ProductService {


    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public ProductService(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    @Validated(OnCreate.class)
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Validated(OnUpdate.class)
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Validated(OnGet.class)
    public Product findById(ProductId productId) {
        return productRepository.findById(productId)
                    .orElseThrow(
                        () -> new ProductNotFoundException(String.format("Product %s not found", productId.getValue()))
                    );
    }

    @Validated(OnGet.class)
    public Page<Product> findAll(int pageNumber, int pageSize) {
        return productRepository.findAll(pageNumber, pageSize);
    }

    @Validated(OnGet.class)
    public Page<Product> findAllByCategoryId(int pageNumber, int pageSize, @Validated CategoryId categoryId) {
        return productRepository.findAllByCategory(pageNumber, pageSize, categoryId);
    }

}
