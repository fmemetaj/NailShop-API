package com.example.nailshopkf.repository;

import com.example.nailshopkf.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
