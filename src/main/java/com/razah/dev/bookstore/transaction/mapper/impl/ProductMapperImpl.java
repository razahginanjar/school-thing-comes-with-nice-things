package com.razah.dev.bookstore.transaction.mapper.impl;

import com.razah.dev.bookstore.transaction.dto.response.ProductResponse;
import com.razah.dev.bookstore.transaction.entity.Product;
import com.razah.dev.bookstore.transaction.mapper.ProductMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductMapperImpl implements ProductMapper {
    @Override
    public ProductResponse map(Product product) {
        return null;
    }
}
