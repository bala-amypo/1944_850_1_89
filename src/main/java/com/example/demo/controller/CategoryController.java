package com.example.demo.controller;

import com.example.demo.model.Category;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return category;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return List.of();
    }
}
