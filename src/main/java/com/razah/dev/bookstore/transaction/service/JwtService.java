package com.razah.dev.bookstore.transaction.service;


import com.razah.dev.bookstore.transaction.dto.response.JWTClaims;
import com.razah.dev.bookstore.transaction.entities.Users;

public interface JwtService {
    String generateToken(Users userAccount);
    Boolean verifyToken(String token);
    JWTClaims claimToken(String token);
}
