package com.example.nailshopkf.service;

import com.example.nailshopkf.entity.Product;
import com.example.nailshopkf.entity.Transaction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class GeneralInfoApiConnector {

    private final RestTemplate restTemplate;
    @Value("${generalinfoapi.url}")
    private String generalInfoApiUrl;

    public GeneralInfoApiConnector() {
        this.restTemplate = new RestTemplate();
    }

    @SuppressWarnings("unchecked")
    public List<Product> searchProducts(String query) {
        String searchUrl = generalInfoApiUrl + "/api/products/search?query=" + query;
        ResponseEntity<List> response = restTemplate.getForEntity(searchUrl, List.class);
        return (List<Product>) response.getBody();
    }

    public Product getProductDetails(Long id) {
        String detailsUrl = generalInfoApiUrl + "/api/products/" + id;
        ResponseEntity<Product> response = restTemplate.getForEntity(detailsUrl, Product.class);
        return response.getBody();
    }

    @SuppressWarnings("unchecked")
    public List<Product> getFavorites() {
        String favoritesUrl = generalInfoApiUrl + "/api/products/favorites";
        ResponseEntity<List> response = restTemplate.getForEntity(favoritesUrl, List.class);
        return (List<Product>) response.getBody();
    }

    @SuppressWarnings("unchecked")
    public List<Product> getCartItems() {
        String cartUrl = generalInfoApiUrl + "/api/products/cart";
        ResponseEntity<List> response = restTemplate.getForEntity(cartUrl, List.class);
        return (List<Product>) response.getBody();
    }

    public Transaction checkout() {
        String checkoutUrl = generalInfoApiUrl + "/api/transaction/checkout";
        ResponseEntity<Transaction> response = restTemplate.getForEntity(checkoutUrl, Transaction.class);
        return response.getBody();
    }

}

