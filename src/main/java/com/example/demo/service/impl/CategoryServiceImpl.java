package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Override
    public String getAllCategories() {
        return "List of categories";
    }
}
