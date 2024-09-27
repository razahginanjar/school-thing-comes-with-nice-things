package com.razah.dev.bookstore.transaction.service.impl;

import com.razah.dev.bookstore.transaction.dto.request.CreateEmployeeRequest;
import com.razah.dev.bookstore.transaction.dto.request.UpdateCustomerRequest;
import com.razah.dev.bookstore.transaction.dto.response.EmployeeResponse;
import com.razah.dev.bookstore.transaction.entity.Employee;
import com.razah.dev.bookstore.transaction.entity.Users;
import com.razah.dev.bookstore.transaction.repository.EmployeeRepository;
import com.razah.dev.bookstore.transaction.service.EmployeeService;
import com.razah.dev.bookstore.transaction.utils.ValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ValidationUtil validationUtil;


    @Override
    public Employee create(CreateEmployeeRequest request, Users users) {
        return null;
    }

    @Override
    public Employee update(UpdateCustomerRequest request) {
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

    @Override
    public EmployeeResponse createResponse(CreateEmployeeRequest request, Users users) {
        return null;
    }

    @Override
    public EmployeeResponse updateResponse(UpdateCustomerRequest request) {
        return null;
    }

    @Override
    public EmployeeResponse getByIdResponse(String id) {
        return null;
    }

    @Override
    public List<EmployeeResponse> getAllResponses() {
        return List.of();
    }
}
