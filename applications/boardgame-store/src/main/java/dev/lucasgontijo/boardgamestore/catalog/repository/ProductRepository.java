package dev.lucasgontijo.boardgamestore.catalog.repository;

import dev.lucasgontijo.boardgamestore.catalog.domain.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.Optional;

@Repository
public class ProductRepository implements ProductRepositoryAPI {

    private final ProductRepositoryJPA productRepositoryJPA;
    private final CategoryRepositoryJPA categoryRepositoryJPA;

    public ProductRepository(ProductRepositoryJPA productRepositoryJPA, CategoryRepositoryJPA categoryRepositoryJPA) {
        this.productRepositoryJPA = productRepositoryJPA;
        this.categoryRepositoryJPA = categoryRepositoryJPA;
    }

    @Override
    public Optional<Product> findById(ProductId productId) {
        Objects.requireNonNull(productId, "Product 'id' cannot be null");
        Objects.requireNonNull(productId.getValue(), "Product 'id' value cannot be null");

        return productRepositoryJPA.findById(productId.getValue()).map(ProductPersistenceMapper::toDomain);
    }

    @Override
    public Page<Product> findAll(int pageNumber, int pageSize) {
        Pageable pageRequest = PageRequest.of(pageNumber, pageSize);

        return productRepositoryJPA.findAll(pageRequest).map(ProductPersistenceMapper::toDomain);
    }

    @Override
    public Page<Product> findAllByCategory(int pageNumber, int pageSize, CategoryId categoryId) {
        Objects.requireNonNull(categoryId, "Category 'id' cannot be null");
        Objects.requireNonNull(categoryId.getValue(), "Category 'id' value cannot be null");

        Pageable pageRequest = PageRequest.of(pageNumber, pageSize);

        CategoryEntity category = categoryRepositoryJPA.findById(categoryId.getValue()).orElse(null);
        return productRepositoryJPA.findAllByCategory(category, pageRequest);

    }

    @Override
    public Product save(Product product) {
        ProductEntity entity = ProductPersistenceMapper.toEntity(product);

        ProductEntity persistedProduct = productRepositoryJPA.save(entity);

        return ProductPersistenceMapper.toDomain(persistedProduct);
    }

    @Override
    public void inactivate(Product product) {
        //TODO criar status no produto
    }
}
