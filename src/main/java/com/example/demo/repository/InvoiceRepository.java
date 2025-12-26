package com.example.demo.repository;

import com.example.demo.model.Invoice;
import com.example.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface InvoiceRepository {

    Invoice save(Invoice invoice);

    Optional<Invoice> findById(Long id);

    List<Invoice> findByUploadedBy(User user);

    // HQL test (mocked in tests)
    List<Invoice> findByAmountGreaterThanHql(Double amount);
}
