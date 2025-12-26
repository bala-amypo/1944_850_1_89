package com.example.demo.service.impl;

import com.example.demo.model.Invoice;
import com.example.demo.repository.*;
import com.example.demo.service.InvoiceService; // Ensure this interface exists
import com.example.demo.util.InvoiceCategorizationEngine;
import org.springframework.stereotype.Service;

@Service // This is the missing piece that creates the Bean
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final UserRepository userRepository;
    private final VendorRepository vendorRepository;
    private final CategorizationRuleRepository ruleRepository;
    private final InvoiceCategorizationEngine engine;

    // Constructor injection as required by Step 0
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
    
    // Implement methods...
}