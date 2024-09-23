package com.razah.dev.bookstore.transaction.service;

import com.razah.dev.bookstore.transaction.dto.request.CustomerRequest;
import com.razah.dev.bookstore.transaction.dto.request.ProductRequest;
import com.razah.dev.bookstore.transaction.entity.Customer;
import com.razah.dev.bookstore.transaction.entity.Product;

import java.util.List;

public interface ProductService {
    Product create(ProductRequest request);
    Product update(ProductRequest request);
    Product getById(String id);
    List<Product> getAll(String request);
    void delete(String id);
}
