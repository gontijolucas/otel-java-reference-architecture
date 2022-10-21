package dev.lucasgontijo.boardgamestore.catalog.controller;

import dev.lucasgontijo.boardgamestore.catalog.domain.CategoryId;
import dev.lucasgontijo.boardgamestore.catalog.domain.Product;
import dev.lucasgontijo.boardgamestore.catalog.domain.ProductId;
import dev.lucasgontijo.boardgamestore.catalog.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(params = { "page", "size" })
    public ResponseEntity<Page<ProductRepresentation>> findAll(@RequestParam("page") int pageNumber,
                                                 @RequestParam("size") int pageSize) {

        Page<Product> all = productService.findAll(pageNumber, pageSize);
        return ResponseEntity.ok(all.map(ProductRepresentationMapper::toProductRepresentation));
    }


    @GetMapping(path = "/category/{id}", params = { "page", "size" })
    public ResponseEntity<Page<ProductRepresentation>> findAllByCategory(@RequestParam(value = "page", defaultValue = "0") int pageNumber,
                                                           @RequestParam(value = "size", defaultValue = "10") int pageSize,
                                                           @PathParam("id") Long categoryId) {

        Page<Product> all = productService.findAllByCategoryId(pageNumber, pageSize, new CategoryId(categoryId));
        return ResponseEntity.ok(all.map(ProductRepresentationMapper::toProductRepresentation));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductRepresentation> findById(@PathParam("id") Long id) {
        ProductId productId = new ProductId(id);

        Product product = productService.findById(productId);

        return ResponseEntity.ok(ProductRepresentationMapper.toProductRepresentation(product));
    }


    @PostMapping
    public ResponseEntity<ProductRepresentation> create(@RequestBody ProductRepresentation productRepresentation) {
        Product product = productService.create(ProductRepresentationMapper.toDomain(productRepresentation));
        return ResponseEntity.status(HttpStatus.CREATED).body(ProductRepresentationMapper.toProductRepresentation(product));
    }


}
