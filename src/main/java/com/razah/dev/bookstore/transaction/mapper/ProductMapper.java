package com.razah.dev.bookstore.transaction.mapper;

import com.razah.dev.bookstore.transaction.dto.response.ProductResponse;
import com.razah.dev.bookstore.transaction.entity.Product;

public interface ProductMapper {
    ProductResponse map(Product product);
}
