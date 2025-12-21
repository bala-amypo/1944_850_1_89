package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class CategorizationRuleController {

    @GetMapping("/rules")
    public String rules() {
        return "Categorization Rules API";
    }
}
