package com.razah.dev.bookstore.transaction.repository;

import com.razah.dev.bookstore.transaction.entity.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductPriceRepository extends JpaRepository<ProductPrice, String> {
    Boolean existsByPrice(Long price);
    Optional<ProductPrice> findByPrice(Long price);
}
