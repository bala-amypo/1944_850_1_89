package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Override
    public String getAllInvoices() {
        return "List of invoices";
    }
}
