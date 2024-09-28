package com.razah.dev.bookstore.transaction.repository;

import com.razah.dev.bookstore.transaction.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, String> {
    Optional<Product> findByCode(String code);
}
