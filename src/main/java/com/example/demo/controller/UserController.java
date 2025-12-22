package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping
    public User register(@RequestBody User user) {
        return user;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return List.of();
    }
}
