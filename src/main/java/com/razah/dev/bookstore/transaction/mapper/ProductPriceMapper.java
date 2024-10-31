package com.razah.dev.bookstore.transaction.mapper;

import com.razah.dev.bookstore.transaction.dto.response.ProductPriceResponse;
import com.razah.dev.bookstore.transaction.entities.PhotoPrice;

public interface ProductPriceMapper {
    ProductPriceResponse map(PhotoPrice photoPrice);
}
