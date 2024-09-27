package com.razah.dev.bookstore.transaction.mapper;

import com.razah.dev.bookstore.transaction.dto.response.BookResponse;
import com.razah.dev.bookstore.transaction.entity.Book;

public interface BookMapper {
    BookResponse map(Book book);
}
