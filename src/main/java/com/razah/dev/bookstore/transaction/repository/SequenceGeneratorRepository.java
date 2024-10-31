package com.razah.dev.bookstore.transaction.repository;

import com.razah.dev.bookstore.transaction.entities.SequenceGenerator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SequenceGeneratorRepository extends JpaRepository<SequenceGenerator, String> {
    Optional<SequenceGenerator> findByName(String name);
}
