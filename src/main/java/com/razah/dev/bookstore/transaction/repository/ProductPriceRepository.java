package com.razah.dev.bookstore.transaction.repository;

import com.razah.dev.bookstore.transaction.entity.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductPriceRepository extends JpaRepository<ProductPrice, String> {
}
