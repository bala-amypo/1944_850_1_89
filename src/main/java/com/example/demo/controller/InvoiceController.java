package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @PostMapping
    public ResponseEntity<String> createInvoice() {
        return ResponseEntity.ok("Invoice created successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getInvoice(@PathVariable Long id) {
        return ResponseEntity.ok("Invoice ID: " + id);
    }

    @GetMapping
    public ResponseEntity<String> getAllInvoices() {
        return ResponseEntity.ok("Invoice list");
    }
}
