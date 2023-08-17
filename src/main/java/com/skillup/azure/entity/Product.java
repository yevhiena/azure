package com.skillup.azure.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("products")
public class Product {

    @Id
    private int id;
    private String name;
    private int quantity;
    private double price;
}
