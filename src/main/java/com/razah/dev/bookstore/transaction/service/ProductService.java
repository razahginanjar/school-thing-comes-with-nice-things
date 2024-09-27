package com.razah.dev.bookstore.transaction.service;

import com.razah.dev.bookstore.transaction.dto.request.CreateProductRequest;
import com.razah.dev.bookstore.transaction.dto.request.UpdateProductRequest;
import com.razah.dev.bookstore.transaction.dto.response.ProductResponse;
import com.razah.dev.bookstore.transaction.entity.Product;

import java.util.List;

public interface ProductService {
    Product create(CreateProductRequest request);
    Product update(UpdateProductRequest request);
    Product getById(String id);
    List<Product> getAll();
    void delete(String id);

    ProductResponse createResponse(CreateProductRequest request);
    ProductResponse updateResponse(UpdateProductRequest request);
    ProductResponse getByIdResponse(String id);
    List<ProductResponse> getAllResponses();
}
