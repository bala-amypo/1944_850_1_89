package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rules")
public class CategorizationRuleController {

    @GetMapping
    public String getAllRules() {
        return "All categorization rules fetched";
    }
}
