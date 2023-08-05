package com.example.nailshopkf.controller;

import com.example.nailshopkf.entity.Product;
import com.example.nailshopkf.service.GeneralInfoApiConnector;
import com.example.nailshopkf.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final GeneralInfoApiConnector generalInfoApiConnector;
    private final ProductService productService;

    public ProductController(GeneralInfoApiConnector generalInfoApiConnector, ProductService productService) {
        this.generalInfoApiConnector = generalInfoApiConnector;
        this.productService = productService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String query) {
        return new ResponseEntity<>(generalInfoApiConnector.searchProducts(query), HttpStatus.OK);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Product> getProductDetails(@PathVariable Long id) {
        return new ResponseEntity<>(generalInfoApiConnector.getProductDetails(id), HttpStatus.OK);
    }

    @GetMapping("/favorites")
    public ResponseEntity<List<Product>> getFavorites() {
        return new ResponseEntity<>(generalInfoApiConnector.getFavorites(), HttpStatus.OK);
    }

    @GetMapping("/cart")
    public ResponseEntity<List<Product>> getCartItems() {
        return new ResponseEntity<>(generalInfoApiConnector.getCartItems(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
