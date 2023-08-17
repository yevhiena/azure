package com.skillup.azure.repository;


import com.skillup.azure.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,Integer> {
    Product findByName(String name);
}

