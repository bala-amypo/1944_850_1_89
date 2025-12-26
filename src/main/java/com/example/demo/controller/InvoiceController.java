package com.example.demo.controller;

import com.example.demo.service.InvoiceService; // Inject the Interface
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    // Parameter 0 will now be satisfied by the InvoiceServiceImpl bean
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }
    
    // ... endpoints
}