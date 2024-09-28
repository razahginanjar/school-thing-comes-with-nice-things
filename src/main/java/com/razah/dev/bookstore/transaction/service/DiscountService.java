package com.razah.dev.bookstore.transaction.service;

import com.razah.dev.bookstore.transaction.dto.request.CreateDiscountRequest;
import com.razah.dev.bookstore.transaction.entity.Discount;

public interface DiscountService {
    Discount getOrSave(CreateDiscountRequest createDiscountRequest);
}