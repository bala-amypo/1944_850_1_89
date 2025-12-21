package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @GetMapping
    public String getInvoices() {
        return "Invoice list";
    }
}
