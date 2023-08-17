package com.skillup.azure.controller;

import com.skillup.azure.entity.Product;
import com.skillup.azure.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("product")
@Tag(name = "Products", description = "Product management")
public class ProductController {

    private final ProductService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('Admin')")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }

    @GetMapping("/all")
    public List<Product> findAllProducts() {
        return service.getProducts();
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('Admin')")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('Admin')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Serializable> deleteProduct(@PathVariable int id) {
        service.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
