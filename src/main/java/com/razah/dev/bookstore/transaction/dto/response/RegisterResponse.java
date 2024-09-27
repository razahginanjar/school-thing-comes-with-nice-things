package com.razah.dev.bookstore.transaction.dto.response;

import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterResponse {
    private String username;
    private List<String> roles;
    private EmployeeResponse merchant;
    private CustomerResponse customer;
}
