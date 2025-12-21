package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @GetMapping
    public String getCategories() {
        return "Category list";
    }
}
