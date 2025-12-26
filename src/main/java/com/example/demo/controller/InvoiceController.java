package com.example.demo.controller;

import com.example.demo.model.Invoice;
import com.example.demo.service.impl.InvoiceServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
@Tag(name = "Invoices Endpoints")
public class InvoiceController {

    private final InvoiceServiceImpl invoiceService;

    public InvoiceController(InvoiceServiceImpl invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Operation(summary = "Upload invoice")
    @PostMapping("/upload/{userId}/{vendorId}")
    public ResponseEntity<Invoice> uploadInvoice(
            @PathVariable Long userId,
            @PathVariable Long vendorId,
            @RequestBody Invoice invoice) {

        return ResponseEntity.ok(
                invoiceService.uploadInvoice(userId, vendorId, invoice)
        );
    }

    @Operation(summary = "Categorize invoice")
    @PostMapping("/categorize/{invoiceId}")
    public ResponseEntity<String> categorizeInvoice(@PathVariable Long invoiceId) {
        return ResponseEntity.ok("Invoice categorized successfully");
    }

    @Operation(summary = "List invoices by user")
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Invoice>> getInvoicesByUser(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                invoiceService.getInvoicesByUser(userId)
        );
    }
}
