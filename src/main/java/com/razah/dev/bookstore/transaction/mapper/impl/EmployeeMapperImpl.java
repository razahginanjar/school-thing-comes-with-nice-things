package com.razah.dev.bookstore.transaction.mapper.impl;

import com.razah.dev.bookstore.transaction.dto.response.EmployeeResponse;
import com.razah.dev.bookstore.transaction.entities.Employee;
import com.razah.dev.bookstore.transaction.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMapperImpl implements EmployeeMapper {
    @Override
    public EmployeeResponse map(Employee employee) {
        return null;
    }
}
