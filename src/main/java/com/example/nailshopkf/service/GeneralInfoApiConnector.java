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
    @Value("${generalInfoApi.url}")
    private String generalInfoApiUrl;

    public GeneralInfoApiConnector() {
        this.restTemplate = new RestTemplate();
    }

    @SuppressWarnings("unchecked")
    public List<Product> searchProducts(String query) {
        String searchUrl = generalInfoApiUrl + "/api/ebay/search/" + query;
        ResponseEntity<List> response = restTemplate.getForEntity(searchUrl, List.class);
        return (List<Product>) response.getBody();
    }

    @SuppressWarnings("unchecked")
    public List<Product> getFavorites() {
        String getFavoritesUrl = generalInfoApiUrl + "/api/favorites";
        ResponseEntity<List> response = restTemplate.getForEntity(getFavoritesUrl, List.class);
        return (List<Product>) response.getBody();
    }

    public void addToFavorites(String productId) {
        String addToFavoritesUrl = generalInfoApiUrl + "/api/favorites/" + productId;
        restTemplate.postForEntity(addToFavoritesUrl, null, Void.class);
    }

    public void removeFromFavorites(String productId) {
        String removeFromFavoritesUrl = generalInfoApiUrl + "/api/favorites/" + productId;
        restTemplate.delete(removeFromFavoritesUrl);
    }

    @SuppressWarnings("unchecked")
    public List<Product> getCartItems() {
        String cartUrl = generalInfoApiUrl + "/api/cart";
        ResponseEntity<List> response = restTemplate.getForEntity(cartUrl, List.class);
        return (List<Product>) response.getBody();
    }

    public void addToCart(String productId) {
        String addToCartUrl = generalInfoApiUrl + "/api/cart/" + productId;
        restTemplate.postForEntity(addToCartUrl, null, Void.class);
    }

    public void removeFromCart(String productId) {
        String removeFromCartUrl = generalInfoApiUrl + "/api/cart/" + productId;
        restTemplate.delete(removeFromCartUrl);
    }

    @SuppressWarnings("unchecked")
    public List<Transaction> getTransactions() {
        String getTransactionsUrl = generalInfoApiUrl + "/api/transactions";
        ResponseEntity<List> response = restTemplate.getForEntity(getTransactionsUrl, List.class);
        return (List<Transaction>) response.getBody();
    }

    public Transaction getTransaction(Long transactionId) {
        String getTransactionUrl = generalInfoApiUrl + "/api/transactions/" + transactionId;
        ResponseEntity<Transaction> response = restTemplate.getForEntity(getTransactionUrl, Transaction.class);
        return response.getBody();
    }

    public Transaction checkout() {
        String checkoutUrl = generalInfoApiUrl + "/api/transaction/checkout";
        ResponseEntity<Transaction> response = restTemplate.getForEntity(checkoutUrl, Transaction.class);
        return response.getBody();
    }

}

