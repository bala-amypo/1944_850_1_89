package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorController {

    @GetMapping("/vendors")
    public String vendors() {
        return "Vendor API working";
    }
}
