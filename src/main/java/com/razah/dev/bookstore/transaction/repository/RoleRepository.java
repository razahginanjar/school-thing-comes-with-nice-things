package com.razah.dev.bookstore.transaction.repository;

import com.razah.dev.bookstore.transaction.entity.UsersRoles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<UsersRoles, String> {
}
