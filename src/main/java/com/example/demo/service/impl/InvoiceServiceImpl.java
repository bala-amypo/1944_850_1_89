package com.example.demo.service.impl;

import com.example.demo.repository.*;
import com.example.demo.service.InvoiceService;
import com.example.demo.util.InvoiceCategorizationEngine;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    // These dependencies must be present for the test suite to pass
    private final InvoiceRepository invoiceRepository;
    private final UserRepository userRepository;
    private final VendorRepository vendorRepository;
    private final CategorizationRuleRepository ruleRepository;
    private final InvoiceCategorizationEngine engine;

    // Strict Step 0 Requirement: You must use Constructor injection
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
    
    // ... implement other methods using the repositories and engine
}