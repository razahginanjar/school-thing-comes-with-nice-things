package com.razah.dev.bookstore.transaction.service.impl;

import com.razah.dev.bookstore.transaction.dto.request.ProductPriceRequest;
import com.razah.dev.bookstore.transaction.entity.ProductPrice;
import com.razah.dev.bookstore.transaction.service.ProductPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductPriceServiceImpl implements ProductPriceService {
    @Override
    public ProductPrice create(ProductPriceRequest request) {
        return null;
    }

    @Override
    public ProductPrice update(ProductPriceRequest request) {
        return null;
    }

    @Override
    public ProductPrice getById(String id) {
        return null;
    }

    @Override
    public List<ProductPrice> getAll() {
        return List.of();
    }

    @Override
    public void delete(String id) {

    }
}
