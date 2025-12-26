package com.example.demo.repository;

import com.example.demo.model.Invoice;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    // ✅ Required by test cases (HQL)
    @Query("SELECT i FROM Invoice i WHERE i.amount > :amount")
    List<Invoice> findByAmountGreaterThanHql(double amount);

    // ✅ Required by InvoiceServiceImpl
    List<Invoice> findByUploadedBy(User uploadedBy);
}
