package com.razah.dev.bookstore.transaction.service;

import com.razah.dev.bookstore.transaction.dto.request.CreateProductPriceRequest;
import com.razah.dev.bookstore.transaction.entity.ProductPrice;

import java.util.List;

public interface ProductPriceService {
    ProductPrice create(CreateProductPriceRequest request);
}
