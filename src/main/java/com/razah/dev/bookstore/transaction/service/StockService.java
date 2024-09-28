package com.razah.dev.bookstore.transaction.service;

import com.razah.dev.bookstore.transaction.dto.request.CreateBookRequest;
import com.razah.dev.bookstore.transaction.dto.request.CreateStockRequest;
import com.razah.dev.bookstore.transaction.dto.request.UpdateBookRequest;
import com.razah.dev.bookstore.transaction.dto.request.UpdateStockRequest;
import com.razah.dev.bookstore.transaction.entity.Book;
import com.razah.dev.bookstore.transaction.entity.Outlet;
import com.razah.dev.bookstore.transaction.entity.Product;
import com.razah.dev.bookstore.transaction.entity.StockProduct;

public interface StockService {
    StockProduct create(CreateStockRequest request, Outlet outlet, Product product);
    StockProduct updateStock(UpdateStockRequest request);
    StockProduct getById(String id);
    StockProduct getByOutletAndProduct(Outlet outlet, Product product);
}
