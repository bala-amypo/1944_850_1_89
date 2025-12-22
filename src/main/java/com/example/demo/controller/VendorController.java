package com.example.demo.controller;

import com.example.demo.model.Vendor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendors")
public class VendorController {

    @PostMapping
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return vendor;
    }

    @GetMapping
    public List<Vendor> getAllVendors() {
        return List.of();
    }
}
