package com.example.demo.repository;

import com.example.demo.model.Invoice;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    // This is the method causing the error
    List<Invoice> findByUploadedBy(User uploadedBy);

    // Optional: you can add more query methods here if needed
}
