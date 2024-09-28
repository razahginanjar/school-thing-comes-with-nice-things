package com.razah.dev.bookstore.transaction.mapper.impl;

import com.razah.dev.bookstore.transaction.dto.response.BookResponse;
import com.razah.dev.bookstore.transaction.entity.Book;
import com.razah.dev.bookstore.transaction.entity.StockProduct;
import com.razah.dev.bookstore.transaction.mapper.BookMapper;
import com.razah.dev.bookstore.transaction.mapper.ProductMapper;
import com.razah.dev.bookstore.transaction.mapper.StockMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookMapperImpl implements BookMapper {
    private final ProductMapper productMapper;
    @Override
    public BookResponse map(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .name(book.getName())
                .type(book.getType())
                .product(productMapper.map(book.getProductBook()))
                .build();
    }
}
