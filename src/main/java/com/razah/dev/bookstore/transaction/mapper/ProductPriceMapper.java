package com.razah.dev.bookstore.transaction.mapper;

import com.razah.dev.bookstore.transaction.dto.response.ProductPriceResponse;
import com.razah.dev.bookstore.transaction.entity.ProductPrice;

public interface ProductPriceMapper {
    ProductPriceResponse map(ProductPrice productPrice);
}
