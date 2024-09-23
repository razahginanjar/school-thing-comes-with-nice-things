package com.razah.dev.bookstore.transaction.repository;

import com.razah.dev.bookstore.transaction.entity.Outlet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutletRepository extends JpaRepository<Outlet, String> {
}
