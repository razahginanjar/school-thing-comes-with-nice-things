package com.razah.dev.bookstore.transaction.mapper;

import com.razah.dev.bookstore.transaction.dto.response.PhotoResponse;
import com.razah.dev.bookstore.transaction.entity.Photo;
import com.razah.dev.bookstore.transaction.entity.StockProduct;

public interface PhotoMapper {
    PhotoResponse map(Photo photo);
}
