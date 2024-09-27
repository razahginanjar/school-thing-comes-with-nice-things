package com.razah.dev.bookstore.transaction.mapper;

import com.razah.dev.bookstore.transaction.dto.response.CustomerResponse;
import com.razah.dev.bookstore.transaction.entity.Customer;

public interface CustomerMapper {
    CustomerResponse map(Customer customer);
}
