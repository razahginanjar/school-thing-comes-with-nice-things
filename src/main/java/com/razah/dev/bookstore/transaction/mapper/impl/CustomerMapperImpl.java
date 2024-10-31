package com.razah.dev.bookstore.transaction.mapper.impl;

import com.razah.dev.bookstore.transaction.dto.response.CustomerResponse;
import com.razah.dev.bookstore.transaction.entities.Customer;
import com.razah.dev.bookstore.transaction.mapper.CustomerMapper;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapperImpl implements CustomerMapper {
    @Override
    public CustomerResponse map(Customer customer) {
        return null;
    }
}
