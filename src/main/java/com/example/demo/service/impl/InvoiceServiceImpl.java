package com.example.demo.service.impl;

import com.example.demo.repository.*;
import com.example.demo.util.InvoiceCategorizationEngine;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final UserRepository userRepository;
    private final VendorRepository vendorRepository;
    private final CategorizationRuleRepository ruleRepository;
    private final InvoiceCategorizationEngine engine;

    // The test suite looks specifically for this constructor signature
    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, 
                              UserRepository userRepository, 
                              VendorRepository vendorRepository, 
                              CategorizationRuleRepository ruleRepository, 
                              InvoiceCategorizationEngine engine) {
        this.invoiceRepository = invoiceRepository;
        this.userRepository = userRepository;
        this.vendorRepository = vendorRepository;
        this.ruleRepository = ruleRepository;
        this.engine = engine;
    }
    
    // ... rest of your methods
}