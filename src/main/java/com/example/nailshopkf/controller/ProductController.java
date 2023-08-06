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

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String query) {
        return new ResponseEntity<>(productService.searchProducts(query), HttpStatus.OK);
    }

    @GetMapping("/favorites")
    public ResponseEntity<List<Product>> getFavorites() {
        return new ResponseEntity<>(productService.getFavorites(), HttpStatus.OK);
    }

    @PostMapping("/favorites/{id}")
    public ResponseEntity<Void> addToFavorites(@PathVariable String id) {
        productService.addToFavorites(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/favorites/{id}")
    public ResponseEntity<Void> removeFromFavorites(@PathVariable String id) {
        productService.removeFromFavorites(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/cart")
    public ResponseEntity<List<Product>> getCartItems() {
        return new ResponseEntity<>(productService.getCartItems(), HttpStatus.OK);
    }

    @PostMapping("/cart/{id}")
    public ResponseEntity<Void> addToCart(@PathVariable String id) {
        productService.addToCart(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/cart/{id}")
    public ResponseEntity<Void> removeFromCart(@PathVariable String id) {
        productService.removeFromCart(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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
