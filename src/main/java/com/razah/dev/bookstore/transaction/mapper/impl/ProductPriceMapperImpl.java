package com.razah.dev.bookstore.transaction.mapper.impl;

import com.razah.dev.bookstore.transaction.dto.response.ProductPriceResponse;
import com.razah.dev.bookstore.transaction.entities.PhotoPrice;
import com.razah.dev.bookstore.transaction.mapper.ProductPriceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductPriceMapperImpl implements ProductPriceMapper {
    @Override
    public ProductPriceResponse map(PhotoPrice photoPrice) {
        return null;
    }
}
