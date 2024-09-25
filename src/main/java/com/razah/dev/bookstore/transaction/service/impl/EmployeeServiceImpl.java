package com.razah.dev.bookstore.transaction.service.impl;

import com.razah.dev.bookstore.transaction.dto.request.CreateEmployeeRequest;
import com.razah.dev.bookstore.transaction.entity.Employee;
import com.razah.dev.bookstore.transaction.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public Employee create(CreateEmployeeRequest request) {
        return null;
    }

    @Override
    public Employee update(CreateEmployeeRequest request) {
        return null;
    }

    @Override
    public Employee getById(String id) {
        return null;
    }

    @Override
    public List<Employee> getAll() {
        return List.of();
    }

    @Override
    public void delete(String id) {

    }
}
