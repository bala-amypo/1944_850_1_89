package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @GetMapping
    public String getAllCategories() {
        return "All categories fetched";
    }
}
