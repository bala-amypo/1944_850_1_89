package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public String getAllUsers() {
        return "List of users";
    }

    @Override
    public String getUserById(Long id) {
        return "User with ID: " + id;
    }
}
