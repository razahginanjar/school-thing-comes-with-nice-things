package com.razah.dev.bookstore.transaction.repository;

import com.razah.dev.bookstore.transaction.entity.StockProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockProductRepository extends JpaRepository<StockProduct, String> {
}
