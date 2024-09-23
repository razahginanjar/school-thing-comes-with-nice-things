package com.razah.dev.bookstore.transaction.service;

import com.razah.dev.bookstore.transaction.dto.request.CustomerRequest;
import com.razah.dev.bookstore.transaction.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer create(CustomerRequest request);
    Customer update(CustomerRequest request);
    Customer getById(String id);
    List<Customer> getAll();
    void delete(String id);
}
