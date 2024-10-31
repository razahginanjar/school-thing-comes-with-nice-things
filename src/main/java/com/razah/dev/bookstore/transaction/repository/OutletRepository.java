package com.razah.dev.bookstore.transaction.repository;

import com.razah.dev.bookstore.transaction.entities.Outlet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OutletRepository extends JpaRepository<Outlet, String> {
    Boolean existsByCode(String code);
    Optional<Outlet> findByCode(String code);
}
