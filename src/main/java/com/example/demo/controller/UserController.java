package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public String getAllUsers() {
        return "All users fetched";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id) {
        return "User with id " + id;
    }
}
