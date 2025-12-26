package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.util.InvoiceCategorizationEngine;

import java.util.List;

public class InvoiceServiceImpl {

    private final InvoiceRepository invoiceRepo;
    private final UserRepository userRepo;
    private final VendorRepository vendorRepo;
    private final CategorizationRuleRepository ruleRepo;
    private final InvoiceCategorizationEngine engine;

    public InvoiceServiceImpl(
            InvoiceRepository invoiceRepo,
            UserRepository userRepo,
            VendorRepository vendorRepo,
            CategorizationRuleRepository ruleRepo,
            InvoiceCategorizationEngine engine) {

        this.invoiceRepo = invoiceRepo;
        this.userRepo = userRepo;
        this.vendorRepo = vendorRepo;
        this.ruleRepo = ruleRepo;
        this.engine = engine;
    }

    public Invoice uploadInvoice(Long userId, Long vendorId, Invoice invoice) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Vendor vendor = vendorRepo.findById(vendorId)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found"));

        invoice.setUploadedBy(user);
        invoice.setVendor(vendor);
        return invoiceRepo.save(invoice);
    }

    public Invoice getInvoice(Long id) {
        return invoiceRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invoice not found"));
    }

    public List<Invoice> getInvoicesByUser(Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return invoiceRepo.findByUploadedBy(user);
    }
}
