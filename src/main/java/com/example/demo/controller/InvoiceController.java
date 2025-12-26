package com.example.demo.controller;

import com.example.demo.model.Invoice;
import com.example.demo.service.InvoiceService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping("/upload")
    public Invoice uploadInvoice(
            @RequestParam Long userId,
            @RequestParam Long vendorId,
            @RequestBody Invoice invoice
    ) {
        return invoiceService.uploadInvoice(userId, vendorId, invoice);
    }

    @PostMapping("/{id}/categorize")
    public Invoice categorize(@PathVariable Long id) {
        return invoiceService.categorizeInvoice(id);
    }

    @GetMapping("/user/{userId}")
    public List<Invoice> getByUser(@PathVariable Long userId) {
        return invoiceService.getInvoicesByUser(userId);
    }

    @GetMapping("/{id}")
    public Invoice getInvoice(@PathVariable Long id) {
        return invoiceService.getInvoice(id);
    }
}
