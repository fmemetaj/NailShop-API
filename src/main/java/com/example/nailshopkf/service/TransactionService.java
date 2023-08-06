package com.example.nailshopkf.service;

import com.example.nailshopkf.entity.Transaction;
import com.example.nailshopkf.exceptions.TransactionNotFoundException;
import com.example.nailshopkf.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private TransactionRepository transactionRepository;
    private GeneralInfoApiConnector apiConnector;

    public TransactionService(TransactionRepository transactionRepository, GeneralInfoApiConnector apiConnector) {
        this.transactionRepository = transactionRepository;
        this.apiConnector = apiConnector;
    }

    public List<Transaction> getAllTransactions() {
        this.transactionRepository.saveAll(apiConnector.getTransactions());
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(Long id) {
        if (!transactionRepository.existsById(id)) {
            this.transactionRepository.save(apiConnector.getTransaction(id));
        }
        return transactionRepository.findById(id)
                .orElseThrow(TransactionNotFoundException::new);
    }

    public Transaction checkout() {
        return apiConnector.checkout();
    }

}
