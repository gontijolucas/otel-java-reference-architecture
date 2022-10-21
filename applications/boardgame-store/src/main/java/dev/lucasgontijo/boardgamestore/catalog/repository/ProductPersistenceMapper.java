package dev.lucasgontijo.boardgamestore.catalog.repository;

import dev.lucasgontijo.boardgamestore.catalog.domain.Product;
import dev.lucasgontijo.boardgamestore.catalog.domain.ProductEntity;
import dev.lucasgontijo.boardgamestore.catalog.domain.ProductId;

public class ProductPersistenceMapper {


    public static Product toDomain(ProductEntity entity) {
        Product product = new Product();
        product.setId(new ProductId(entity.getId()));
        product.setDescription(entity.getDescription());
        product.setEditor(entity.getEditor());
        product.setName(entity.getName());
        product.setPlayerNumber(entity.getPlayerNumber());
        product.setPlayTime(entity.getPlayTime());
        product.setPrice(entity.getPrice());
        product.setSku(entity.getSku());
        product.setCategory(CategoryPersistenceMapper.toDomain(entity.getCategory()));
        return product;
    }

    public static ProductEntity toEntity(Product product) {
        ProductEntity entity = new ProductEntity();
        entity.setCategory(CategoryPersistenceMapper.toEntity(product.getCategory()));
        entity.setPrice(product.getPrice());
        entity.setDescription(product.getDescription());
        entity.setName(product.getName());
        entity.setPlayerNumber(product.getPlayerNumber());
        entity.setSku(product.getSku());
        entity.setPlayTime(product.getPlayTime());
        entity.setEditor(product.getEditor());
        entity.setId(product.getId().getValue()!=null ? product.getId().getValue() : null);
        return entity;
    }

}
