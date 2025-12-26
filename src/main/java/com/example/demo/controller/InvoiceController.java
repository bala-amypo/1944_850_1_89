package com.example.demo.controller;

import com.example.demo.model.Invoice;
import com.example.demo.service.InvoiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping("/{userId}/{vendorId}")
    public Invoice uploadInvoice(@PathVariable Long userId,
                                 @PathVariable Long vendorId,
                                 @RequestBody Invoice invoice) {

        return invoiceService.uploadInvoice(userId, vendorId, invoice);
    }

    @GetMapping("/{id}")
    public Invoice getInvoice(@PathVariable Long id) {
        return invoiceService.getInvoice(id);
    }

    @GetMapping("/user/{userId}")
    public List<Invoice> getInvoicesByUser(@PathVariable Long userId) {
        return invoiceService.getInvoicesByUser(userId);
    }

    @GetMapping("/amount/{amount}")
    public List<Invoice> getInvoicesAboveAmount(@PathVariable Double amount) {
        return invoiceService.getInvoicesAboveAmount(amount);
    }
}
