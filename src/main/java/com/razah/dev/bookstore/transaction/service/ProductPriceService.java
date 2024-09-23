package com.razah.dev.bookstore.transaction.service;

import com.razah.dev.bookstore.transaction.dto.request.CustomerRequest;
import com.razah.dev.bookstore.transaction.dto.request.ProductPriceRequest;
import com.razah.dev.bookstore.transaction.entity.Customer;
import com.razah.dev.bookstore.transaction.entity.Product;
import com.razah.dev.bookstore.transaction.entity.ProductPrice;

import java.util.List;

public interface ProductPriceService {
    ProductPrice create(ProductPriceRequest request);
    ProductPrice update(ProductPriceRequest request);
    ProductPrice getById(String id);
    List<ProductPrice> getAll();
    void delete(String id);
}
