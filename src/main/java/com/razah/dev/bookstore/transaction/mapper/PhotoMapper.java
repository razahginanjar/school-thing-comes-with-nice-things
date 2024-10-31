package com.razah.dev.bookstore.transaction.mapper;

import com.razah.dev.bookstore.transaction.dto.response.PhotoResponse;
import com.razah.dev.bookstore.transaction.entities.Photo;

public interface PhotoMapper {
    PhotoResponse map(Photo photo);
}
