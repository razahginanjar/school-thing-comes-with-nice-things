package com.razah.dev.bookstore.transaction.service;

import com.razah.dev.bookstore.transaction.dto.request.CreateEmployeeRequest;
import com.razah.dev.bookstore.transaction.dto.request.UpdateEmployeeRequest;
import com.razah.dev.bookstore.transaction.dto.response.EmployeeResponse;
import com.razah.dev.bookstore.transaction.entities.Employee;
import com.razah.dev.bookstore.transaction.entities.Users;

import java.util.List;

public interface EmployeeService {
    Employee create(CreateEmployeeRequest request,  Users users);
    Employee update(UpdateEmployeeRequest request);
    Employee getById(String id);
    List<Employee> getAll();
    void delete(String id);

    EmployeeResponse createResponse(CreateEmployeeRequest request,  Users users);
    EmployeeResponse updateResponse(UpdateEmployeeRequest request);
    EmployeeResponse getByIdResponse(String id);
    List<EmployeeResponse> getAllResponses();
}
