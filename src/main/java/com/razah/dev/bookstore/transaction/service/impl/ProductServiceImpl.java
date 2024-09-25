package com.razah.dev.bookstore.transaction.service.impl;

import com.razah.dev.bookstore.transaction.dto.request.CreateProductRequest;
import com.razah.dev.bookstore.transaction.entity.Product;
import com.razah.dev.bookstore.transaction.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    @Override
    public Product create(CreateProductRequest request) {
        return null;
    }

    @Override
    public Product update(CreateProductRequest request) {
        return null;
    }

    @Override
    public Product getById(String id) {
        return null;
    }

    @Override
    public List<Product> getAll(String request) {
        return List.of();
    }

    @Override
    public void delete(String id) {

    }
}
