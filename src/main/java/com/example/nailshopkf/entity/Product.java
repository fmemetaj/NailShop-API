package com.example.nailshopkf.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Product {

    @Id
    private String productId;
    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private String purchaseUrl;

}
