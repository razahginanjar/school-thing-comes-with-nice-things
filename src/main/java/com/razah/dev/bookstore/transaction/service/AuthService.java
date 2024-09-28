package com.razah.dev.bookstore.transaction.service;


import com.razah.dev.bookstore.transaction.dto.request.LoginRequest;
import com.razah.dev.bookstore.transaction.dto.request.RegisterCustomer;
import com.razah.dev.bookstore.transaction.dto.request.RegisterEmployeeRequest;
import com.razah.dev.bookstore.transaction.dto.response.LoginResponse;
import com.razah.dev.bookstore.transaction.dto.response.RegisterResponse;

public interface AuthService {
    LoginResponse login(LoginRequest login);

    RegisterResponse registerEmployee(RegisterEmployeeRequest request);

    RegisterResponse registerCustomer(RegisterCustomer request);
}
