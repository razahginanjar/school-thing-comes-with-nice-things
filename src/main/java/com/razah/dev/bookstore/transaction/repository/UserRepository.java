package com.razah.dev.bookstore.transaction.repository;

import com.razah.dev.bookstore.transaction.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, String> {
}
