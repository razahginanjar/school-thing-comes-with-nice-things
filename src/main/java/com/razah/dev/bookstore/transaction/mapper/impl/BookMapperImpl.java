package com.razah.dev.bookstore.transaction.mapper.impl;

import com.razah.dev.bookstore.transaction.dto.response.BookResponse;
import com.razah.dev.bookstore.transaction.entity.Book;
import com.razah.dev.bookstore.transaction.mapper.BookMapper;
import org.springframework.stereotype.Service;

@Service
public class BookMapperImpl implements BookMapper {
    @Override
    public BookResponse map(Book book) {
        return null;
    }
}
