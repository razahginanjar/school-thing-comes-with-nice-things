package com.razah.dev.bookstore.transaction.mapper;

import com.razah.dev.bookstore.transaction.dto.response.StockResponse;
import com.razah.dev.bookstore.transaction.entity.StockProduct;

public interface StockMapper {
    StockResponse map(StockProduct stockProduct);
}
