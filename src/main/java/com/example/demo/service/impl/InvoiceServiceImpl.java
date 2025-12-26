package com.example.demo.service.impl;

import com.example.demo.model.Category;
import com.example.demo.model.CategorizationRule;
import com.example.demo.model.Invoice;
import com.example.demo.model.Vendor;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.CategorizationRuleRepository;
import com.example.demo.repository.InvoiceRepository;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.InvoiceService;
import com.example.demo.util.InvoiceCategorizationEngine;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final CategoryRepository categoryRepository;
    private final VendorRepository vendorRepository;
    private final CategorizationRuleRepository ruleRepository;
    private final InvoiceCategorizationEngine engine;

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

    @Override
    public Invoice uploadInvoice(Long userId, Long vendorId, Invoice invoice) {

        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));

        invoice.setVendor(vendor);

        // Apply categorization rules
        List<CategorizationRule> rules = ruleRepository.findAll();
        String categoryName = engine.determineCategory(invoice, rules);

        if (categoryName != null) {
            Category category = categoryRepository
                    .findByCategoryName(categoryName)
                    .orElse(null);
            invoice.setCategory(category);
        }

        return invoiceRepository.save(invoice);
    }

    @Override
    public List<Invoice> getInvoicesByUser(Long userId) {
        return invoiceRepository.findByUploadedById(userId);
    }
}
