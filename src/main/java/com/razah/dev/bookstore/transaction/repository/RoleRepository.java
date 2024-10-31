package com.razah.dev.bookstore.transaction.repository;

import com.razah.dev.bookstore.transaction.constant.Roles;
import com.razah.dev.bookstore.transaction.entities.UsersRoles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<UsersRoles, String> {
    Optional<UsersRoles> findByRoles(Roles roles);
}
