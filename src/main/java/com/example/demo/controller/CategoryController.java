package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class CategoryController {

    @GetMapping("/categories")
    public String categories() {
        return "Categories API";
    }
}
