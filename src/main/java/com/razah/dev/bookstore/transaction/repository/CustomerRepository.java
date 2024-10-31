package com.razah.dev.bookstore.transaction.repository;

import com.razah.dev.bookstore.transaction.entities.Customer;
import com.razah.dev.bookstore.transaction.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    Optional<Customer> findByTelephone(String telephone);
    Boolean existsByTelephone(String telephone);
    Optional<Customer> findCustomerByUsersCustomer(Users customer);
}
