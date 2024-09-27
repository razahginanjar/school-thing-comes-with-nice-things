package com.razah.dev.bookstore.transaction.service;

import com.razah.dev.bookstore.transaction.dto.request.CreateCustomerRequest;
import com.razah.dev.bookstore.transaction.dto.request.CreatePhotoRequest;
import com.razah.dev.bookstore.transaction.dto.request.UpdateCustomerRequest;
import com.razah.dev.bookstore.transaction.dto.request.UpdatePhotoRequest;
import com.razah.dev.bookstore.transaction.dto.response.PhotoResponse;
import com.razah.dev.bookstore.transaction.entity.Customer;
import com.razah.dev.bookstore.transaction.entity.Photo;
import com.razah.dev.bookstore.transaction.entity.Users;

import java.util.List;

public interface PhotoService {
    Photo create(CreatePhotoRequest request);
    Photo update(UpdatePhotoRequest request);
    Photo getById(String id);
    List<Photo> getAll();
    void delete(String id);

    PhotoResponse createResponse(CreatePhotoRequest request);
    PhotoResponse updateResponse(UpdatePhotoRequest request);
    PhotoResponse getByIdResponse(String id);
    List<PhotoResponse> getAllResponses();
}
