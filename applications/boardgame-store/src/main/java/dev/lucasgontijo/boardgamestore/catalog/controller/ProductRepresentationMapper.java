package dev.lucasgontijo.boardgamestore.catalog.controller;

import dev.lucasgontijo.boardgamestore.catalog.domain.*;

public class ProductRepresentationMapper {

    public static Product toDomain(ProductRepresentation productRepresentation) {
        Product product = new Product();
        product.setId(new ProductId(productRepresentation.id()));
        product.setDescription(productRepresentation.description());
        product.setEditor(productRepresentation.editor());
        product.setName(productRepresentation.name());
        product.setPlayerNumber(productRepresentation.playerNumber());
        product.setPrice(productRepresentation.price());
        product.setSku(productRepresentation.sku());
        Category category = new Category();
        category.setId(new CategoryId(productRepresentation.categoryId()));
        product.setCategory(category);
        return product;
    }

    public static ProductRepresentation toProductRepresentation(Product product) {
        return new ProductRepresentation(
            product.getId().getValue(),
            product.getName(),
            product.getDescription(),
            product.getSku(),
            product.getEditor(),
            product.getPlayerNumber(),
            product.getPlayTime(),
            product.getPrice(),
            product.getCategory().getId().getValue()
        );
    }

}
