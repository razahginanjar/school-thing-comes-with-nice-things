package com.razah.dev.bookstore.transaction.service;

import com.razah.dev.bookstore.transaction.dto.request.CreateCustomerRequest;
import com.razah.dev.bookstore.transaction.dto.request.UpdateCustomerRequest;
import com.razah.dev.bookstore.transaction.dto.response.CustomerResponse;
import com.razah.dev.bookstore.transaction.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer create(CreateCustomerRequest request);
    Customer update(UpdateCustomerRequest request);
    Customer getById(String id);
    List<Customer> getAll();
    void delete(String id);

    CustomerResponse createResponse(CreateCustomerRequest request);
    CustomerResponse updateResponse(UpdateCustomerRequest request);
    CustomerResponse getByIdResponse(String id);
    List<CustomerResponse> getAllResponses();
}
