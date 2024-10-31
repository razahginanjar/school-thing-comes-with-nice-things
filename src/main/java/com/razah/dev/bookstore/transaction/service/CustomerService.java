package com.razah.dev.bookstore.transaction.service;

import com.razah.dev.bookstore.transaction.dto.request.CreateCustomerRequest;
import com.razah.dev.bookstore.transaction.dto.request.UpdateCustomerRequest;
import com.razah.dev.bookstore.transaction.dto.request.UpdatePointsCustomerRequest;
import com.razah.dev.bookstore.transaction.dto.response.CustomerResponse;
import com.razah.dev.bookstore.transaction.entities.Customer;
import com.razah.dev.bookstore.transaction.entities.Users;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(CreateCustomerRequest createCustomerRequest, Users users);
    Customer update(UpdateCustomerRequest request);
    Customer getById(String id);
    List<Customer> getAll();
    Customer updatePoints(UpdatePointsCustomerRequest request);
    Customer getByUser();
    void deleteById(String id);

    CustomerResponse createCustomerResponse(CreateCustomerRequest createCustomerRequest, Users users);
    CustomerResponse updateResponse(UpdateCustomerRequest request);
    CustomerResponse getByIdResponse(String id);
    List<CustomerResponse> getAllResponses();
    CustomerResponse getByUserResponse();
}
