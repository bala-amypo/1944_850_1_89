package com.example.demo.controller;

import com.example.demo.model.Invoice;
import com.example.demo.service.impl.InvoiceServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    private final InvoiceServiceImpl invoiceService;

    public InvoiceController(InvoiceServiceImpl invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping("/{userId}/{vendorId}")
    public ResponseEntity<Invoice> uploadInvoice(
            @PathVariable Long userId,
            @PathVariable Long vendorId,
            @RequestBody Invoice invoice) {

        return ResponseEntity.ok(
                invoiceService.uploadInvoice(userId, vendorId, invoice)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getInvoice(@PathVariable Long id) {
        return ResponseEntity.ok(invoiceService.getInvoice(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Invoice>> getInvoicesByUser(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                invoiceService.getInvoicesByUser(userId)
        );
    }
}
