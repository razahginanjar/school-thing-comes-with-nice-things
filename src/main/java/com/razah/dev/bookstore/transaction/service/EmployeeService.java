package com.razah.dev.bookstore.transaction.service;

import com.razah.dev.bookstore.transaction.dto.request.CustomerRequest;
import com.razah.dev.bookstore.transaction.dto.request.EmployeeRequest;
import com.razah.dev.bookstore.transaction.entity.Customer;
import com.razah.dev.bookstore.transaction.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee create(EmployeeRequest request);
    Employee update(EmployeeRequest request);
    Employee getById(String id);
    List<Employee> getAll();
    void delete(String id);
}
