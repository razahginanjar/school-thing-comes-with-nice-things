package com.razah.dev.bookstore.transaction.mapper.impl;

import com.razah.dev.bookstore.transaction.dto.response.ProductResponse;
import com.razah.dev.bookstore.transaction.entity.Product;
import com.razah.dev.bookstore.transaction.mapper.ProductMapper;
import com.razah.dev.bookstore.transaction.mapper.ProductPriceMapper;
import com.razah.dev.bookstore.transaction.mapper.StockMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductMapperImpl implements ProductMapper {
    private final ProductPriceMapper productPriceMapper;

    @Override
    public ProductResponse map(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .code(product.getCode())
                .price(productPriceMapper.map(product.getProductPrice()))
                .build();
    }
}
