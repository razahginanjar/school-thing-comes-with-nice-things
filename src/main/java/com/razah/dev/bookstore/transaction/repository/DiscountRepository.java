package com.razah.dev.bookstore.transaction.repository;

import com.razah.dev.bookstore.transaction.constant.PercentageDiscount;
import com.razah.dev.bookstore.transaction.entities.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, String> {
    Optional<Discount> findByDiscount(PercentageDiscount discount);
}
