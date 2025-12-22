package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.VendorService;

@Service
public class VendorServiceImpl implements VendorService {

    @Override
    public String getAllVendors() {
        return "List of vendors";
    }
}
