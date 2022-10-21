package dev.lucasgontijo.boardgamestore.catalog.repository;

import dev.lucasgontijo.boardgamestore.catalog.domain.Product;
import dev.lucasgontijo.boardgamestore.catalog.domain.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductRepositoryJPA extends JpaRepository<ProductEntity, Long> {

    Page<Product> findAllByCategory(Long categoryId, Pageable pageRequest);

}
