package com.example.demo.service.impl;

import com.example.demo.model.CategorizationRule;
import com.example.demo.model.Category;
import com.example.demo.model.Invoice;
import com.example.demo.model.Vendor;
import com.example.demo.repository.CategorizationRuleRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.InvoiceRepository;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.InvoiceService;
import com.example.demo.util.InvoiceCategorizationEngine;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final CategoryRepository categoryRepository;
    private final VendorRepository vendorRepository;
    private final CategorizationRuleRepository ruleRepository;
    private final InvoiceCategorizationEngine engine;

    // ✅ REQUIRED CONSTRUCTOR (MATCHES SPRING + TESTS)
    public InvoiceServiceImpl(
            InvoiceRepository invoiceRepository,
            CategoryRepository categoryRepository,
            VendorRepository vendorRepository,
            CategorizationRuleRepository ruleRepository,
            InvoiceCategorizationEngine engine
    ) {
        this.invoiceRepository = invoiceRepository;
        this.categoryRepository = categoryRepository;
        this.vendorRepository = vendorRepository;
        this.ruleRepository = ruleRepository;
        this.engine = engine;
    }

    // ✅ CREATE INVOICE
    @Override
    public Invoice createInvoice(Invoice invoice) {

        // Set uploaded time if not present
        if (invoice.getUploadedAt() == null) {
            invoice.setUploadedAt(LocalDateTime.now());
        }

        // Load categorization rules
        List<CategorizationRule> rules = ruleRepository.findAll();

        // Determine category name using engine
        String categoryName = engine.determineCategory(invoice, rules);

        if (categoryName != null) {
            Category category = categoryRepository
                    .findByCategoryName(categoryName)
                    .orElse(null);

            invoice.setCategory(category);
        }

        return invoiceRepository.save(invoice);
    }

    // ✅ GET ALL INVOICES
    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    // ✅ GET INVOICE BY ID
    @Override
    public Invoice getInvoiceById(Long id) {
        return invoiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice not found with id: " + id));
    }

    // ✅ DELETE INVOICE
    @Override
    public void deleteInvoice(Long id) {
        if (!invoiceRepository.existsById(id)) {
            throw new RuntimeException("Invoice not found with id: " + id);
        }
        invoiceRepository.deleteById(id);
    }
}
