package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategorizationRuleController {

    @GetMapping("/rules")
    public String rules() {
        return "Categorization Rule API working";
    }
}
