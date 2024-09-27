package com.razah.dev.bookstore.transaction.mapper;

import com.razah.dev.bookstore.transaction.dto.response.PhotoResponse;
import com.razah.dev.bookstore.transaction.entity.Photo;

public interface PhotoMapper {
    PhotoResponse map(Photo photo);
}
