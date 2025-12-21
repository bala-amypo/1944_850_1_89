package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendors")
public class VendorController {

    @GetMapping
    public String getVendors() {
        return "Vendor list";
    }
}
