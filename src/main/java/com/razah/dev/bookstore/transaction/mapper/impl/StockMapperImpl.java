package com.razah.dev.bookstore.transaction.mapper.impl;

import com.razah.dev.bookstore.transaction.dto.response.StockResponse;
import com.razah.dev.bookstore.transaction.entity.StockProduct;
import com.razah.dev.bookstore.transaction.mapper.StockMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockMapperImpl implements StockMapper {
    @Override
    public StockResponse map(StockProduct stockProduct) {
        return null;
    }
}
