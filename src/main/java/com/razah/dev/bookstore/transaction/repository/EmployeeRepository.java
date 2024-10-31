package com.razah.dev.bookstore.transaction.repository;

import com.razah.dev.bookstore.transaction.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
