package com.razah.dev.bookstore.transaction.service;

import com.razah.dev.bookstore.transaction.dto.request.CreateEmployeeRequest;
import com.razah.dev.bookstore.transaction.dto.request.UpdateCustomerRequest;
import com.razah.dev.bookstore.transaction.dto.response.EmployeeResponse;
import com.razah.dev.bookstore.transaction.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee create(CreateEmployeeRequest request);
    Employee update(UpdateCustomerRequest request);
    Employee getById(String id);
    List<Employee> getAll();
    void delete(String id);

    EmployeeResponse createResponse(CreateEmployeeRequest request);
    EmployeeResponse updateResponse(UpdateCustomerRequest request);
    EmployeeResponse getByIdResponse(String id);
    List<EmployeeResponse> getAllResponses();
}
