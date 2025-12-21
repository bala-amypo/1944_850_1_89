package com.example.demo.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    public String generateToken(String username) {
        return "dummy-jwt-token";
    }

    public String extractUsername(String token) {
        return "user";
    }

    public boolean validateToken(String token) {
        return true;
    }
}
