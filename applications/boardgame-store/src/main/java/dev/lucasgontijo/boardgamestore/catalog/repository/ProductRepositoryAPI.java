package dev.lucasgontijo.boardgamestore.catalog.repository;

import dev.lucasgontijo.boardgamestore.catalog.domain.CategoryId;
import dev.lucasgontijo.boardgamestore.catalog.domain.Product;
import dev.lucasgontijo.boardgamestore.catalog.domain.ProductId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductRepositoryAPI {

    Optional<Product> findById(ProductId productId);

    Page<Product> findAll(int pageNumber, int pageSize);

    Page<Product> findAllByCategory(int pageNumber, int pageSize, CategoryId categoryId);

    Product save(Product product);

    void inactivate(Product product);
}
