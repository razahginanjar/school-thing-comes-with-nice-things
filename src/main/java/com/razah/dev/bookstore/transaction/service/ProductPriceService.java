package com.razah.dev.bookstore.transaction.service;

import com.razah.dev.bookstore.transaction.dto.request.CreateProductPriceRequest;
import com.razah.dev.bookstore.transaction.entities.PhotoPrice;

public interface ProductPriceService {
    PhotoPrice create(CreateProductPriceRequest request);
}
