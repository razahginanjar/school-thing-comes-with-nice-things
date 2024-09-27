package com.razah.dev.bookstore.transaction.service;

import com.razah.dev.bookstore.transaction.dto.request.CreateBookRequest;
import com.razah.dev.bookstore.transaction.dto.request.CreatePhotoRequest;
import com.razah.dev.bookstore.transaction.dto.request.UpdateBookRequest;
import com.razah.dev.bookstore.transaction.dto.request.UpdatePhotoRequest;
import com.razah.dev.bookstore.transaction.dto.response.BookResponse;
import com.razah.dev.bookstore.transaction.dto.response.PhotoResponse;
import com.razah.dev.bookstore.transaction.entity.Book;
import com.razah.dev.bookstore.transaction.entity.Photo;

import java.util.List;

public interface BookService {
    Book create(CreateBookRequest request);
    Book update(UpdateBookRequest request);
    Book getById(String id);
    List<Book> getAll();
    void delete(String id);

    BookResponse createResponse(CreateBookRequest request);
    BookResponse updateResponse(UpdateBookRequest request);
    BookResponse getByIdResponse(String id);
    List<BookResponse> getAllResponses();
}
