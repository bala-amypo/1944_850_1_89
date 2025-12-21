package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class AuthController {

    @GetMapping("/auth")
    public String auth() {
        return "Auth API";
    }
}
