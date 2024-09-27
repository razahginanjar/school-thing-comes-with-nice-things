package com.razah.dev.bookstore.transaction.service;

import com.razah.dev.bookstore.transaction.entity.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    Users getUserByID(String idUser);
    Users getByContext();
    void deleteUserByID(String idUser);
}
