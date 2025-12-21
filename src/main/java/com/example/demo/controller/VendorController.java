package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class VendorController {

    @GetMapping("/vendors")
    public String vendors() {
        return "Vendors API";
    }
}
