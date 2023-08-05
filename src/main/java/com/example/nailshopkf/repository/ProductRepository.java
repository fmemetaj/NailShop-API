package com.example.nailshopkf.repository;

import com.example.nailshopkf.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
