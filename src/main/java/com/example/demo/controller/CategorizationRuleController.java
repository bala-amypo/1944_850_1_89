package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rules")
public class CategorizationRuleController {

    @PostMapping
    public ResponseEntity<String> createRule() {
        return ResponseEntity.ok("Rule created successfully");
    }

    @GetMapping
    public ResponseEntity<String> getRules() {
        return ResponseEntity.ok("Rules list");
    }
}
