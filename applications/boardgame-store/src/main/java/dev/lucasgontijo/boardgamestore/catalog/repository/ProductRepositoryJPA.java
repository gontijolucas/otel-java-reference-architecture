package dev.lucasgontijo.boardgamestore.catalog.repository;

import dev.lucasgontijo.boardgamestore.catalog.domain.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositoryJPA extends JpaRepository<ProductEntity, Long> {
}
