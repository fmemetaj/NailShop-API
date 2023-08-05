package com.example.nailshopkf.service;

import com.example.nailshopkf.entity.Transaction;
import com.example.nailshopkf.exceptions.TransactionNotFoundException;
import com.example.nailshopkf.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id)
                .orElseThrow(TransactionNotFoundException::new);
    }

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public void deleteTransaction(Long id) {
        transactionRepository.findById(id)
                .orElseThrow(TransactionNotFoundException::new);
        transactionRepository.deleteById(id);
    }
}
