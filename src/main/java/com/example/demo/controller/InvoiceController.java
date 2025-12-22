package com.example.demo.controller;

import com.example.demo.model.Invoice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @PostMapping
    public Invoice uploadInvoice(@RequestBody Invoice invoice) {
        return invoice;
    }

    @GetMapping
    public List<Invoice> getAllInvoices() {
        return List.of();
    }
}
