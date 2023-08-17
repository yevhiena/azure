package com.skillup.azure.service;

import com.skillup.azure.entity.Product;
import com.skillup.azure.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteProduct(int id) {
        repository.deleteById(id);
    }

    public Product updateProduct(Product product) {
        Optional<Product> existingProduct = repository.findById(product.getId());
        if (existingProduct.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        var updatedProduct = existingProduct.get();
        updatedProduct .setName(product.getName());
        updatedProduct .setQuantity(product.getQuantity());
        updatedProduct .setPrice(product.getPrice());
        return repository.save(updatedProduct);
    }


}
