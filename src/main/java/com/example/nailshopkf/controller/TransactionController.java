package com.example.nailshopkf.controller;

import com.example.nailshopkf.entity.Transaction;
import com.example.nailshopkf.service.GeneralInfoApiConnector;
import com.example.nailshopkf.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long id) {
        return ResponseEntity.ok(transactionService.getTransactionById(id));
    }

    @PostMapping("/checkout")
    public ResponseEntity<Transaction> checkout() {
        return ResponseEntity.ok(transactionService.checkout());
    }
}
