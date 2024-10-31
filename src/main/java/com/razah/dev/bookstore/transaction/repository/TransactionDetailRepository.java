package com.razah.dev.bookstore.transaction.repository;

import com.razah.dev.bookstore.transaction.entities.TransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDetailRepository extends JpaRepository<TransactionDetail, String> {
}
