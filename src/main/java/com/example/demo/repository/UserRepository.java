package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // Methods required by Step 0: Repository Method Signatures
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email); 
}