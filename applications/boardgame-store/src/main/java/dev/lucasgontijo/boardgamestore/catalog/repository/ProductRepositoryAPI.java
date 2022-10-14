package dev.lucasgontijo.boardgamestore.catalog.repository;

import dev.lucasgontijo.boardgamestore.catalog.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductRepositoryAPI {

    Optional<Product> findById();

    Page<Product> findAll(Pageable pageRequest);

    Page<Product> findAllByCategory(Long categoryId, Pageable pageRequest);

    Product save(Product product);

    void delete(Product product);
}
