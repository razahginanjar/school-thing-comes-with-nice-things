package com.razah.dev.bookstore.transaction.repository;

import com.razah.dev.bookstore.transaction.entity.Outlet;
import com.razah.dev.bookstore.transaction.entity.Product;
import com.razah.dev.bookstore.transaction.entity.StockProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockProductRepository extends JpaRepository<StockProduct, String> {
    Optional<StockProduct> findByOutletStockAndProductStock(Outlet outletStock, Product productStock);
    Boolean existByOutletStockAndProductStock(Outlet outletStock, Product productStock);
}
