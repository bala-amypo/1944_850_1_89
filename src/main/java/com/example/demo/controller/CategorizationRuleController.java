package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rules")
public class CategorizationRuleController {

    @GetMapping
    public String getRules() {
        return "Categorization rules";
    }
}
