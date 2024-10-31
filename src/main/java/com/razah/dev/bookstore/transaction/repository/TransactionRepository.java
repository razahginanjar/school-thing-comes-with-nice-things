package com.razah.dev.bookstore.transaction.repository;

import com.razah.dev.bookstore.transaction.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
