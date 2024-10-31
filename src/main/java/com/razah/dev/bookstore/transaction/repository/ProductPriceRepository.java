package com.razah.dev.bookstore.transaction.repository;

import com.razah.dev.bookstore.transaction.entities.PhotoPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductPriceRepository extends JpaRepository<PhotoPrice, String> {
    Boolean existsByPrice(Long price);
    Optional<PhotoPrice> findByPrice(Long price);
}
