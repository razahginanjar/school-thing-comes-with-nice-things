package com.razah.dev.bookstore.transaction.mapper;

import com.razah.dev.bookstore.transaction.dto.response.EmployeeResponse;
import com.razah.dev.bookstore.transaction.entities.Employee;

public interface EmployeeMapper {
    EmployeeResponse map(Employee employee);
}
