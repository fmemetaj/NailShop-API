package com.example.nailshopkf.service;

import com.example.nailshopkf.entity.Product;
import com.example.nailshopkf.exceptions.ProductNotFoundException;
import com.example.nailshopkf.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final GeneralInfoApiConnector apiConnector;

    public ProductService(ProductRepository productRepository, GeneralInfoApiConnector apiConnector) {
        this.productRepository = productRepository;
        this.apiConnector = apiConnector;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(String id) {
        return productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(String id) {
        productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
        productRepository.deleteById(id);
    }

    public List<Product> searchProducts(String query) {
        return apiConnector.searchProducts(query);
    }

    public List<Product> getFavorites() {
        return apiConnector.getFavorites();
    }

    public void addToFavorites(String productId) {
        apiConnector.addToFavorites(productId);
    }

    public void removeFromFavorites(String productId) {
        apiConnector.removeFromFavorites(productId);
    }

    public List<Product> getCartItems() {
        return apiConnector.getCartItems();
    }

    public void addToCart(String productId) {
        apiConnector.addToCart(productId);
    }

    public void removeFromCart(String productId) {
        apiConnector.removeFromCart(productId);
    }

}
