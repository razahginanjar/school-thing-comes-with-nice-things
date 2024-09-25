package com.razah.dev.bookstore.transaction.service.impl;

import com.razah.dev.bookstore.transaction.dto.request.CreateCustomerRequest;
import com.razah.dev.bookstore.transaction.dto.request.UpdateCustomerRequest;
import com.razah.dev.bookstore.transaction.dto.response.CustomerResponse;
import com.razah.dev.bookstore.transaction.entity.Customer;
import com.razah.dev.bookstore.transaction.repository.CustomerRepository;
import com.razah.dev.bookstore.transaction.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;


    @Override
    public Customer create(CreateCustomerRequest request) {
        return null;
    }

    @Override
    public Customer update(UpdateCustomerRequest request) {
        return null;
    }

    @Override
    public Customer getById(String id) {
        return null;
    }

    @Override
    public List<Customer> getAll() {
        return List.of();
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public CustomerResponse createResponse(CreateCustomerRequest request) {
        return null;
    }

    @Override
    public CustomerResponse updateResponse(UpdateCustomerRequest request) {
        return null;
    }

    @Override
    public CustomerResponse getByIdResponse(String id) {
        return null;
    }

    @Override
    public List<CustomerResponse> getAllResponses() {
        return List.of();
    }
}
