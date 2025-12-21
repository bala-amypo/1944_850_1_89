package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class InvoiceController {

    @GetMapping("/invoices")
    public String invoices() {
        return "Invoices API";
    }
}
