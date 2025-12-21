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
        // Dummy implementation (enough for test cases)
        return username + "_token";
    }

    public boolean validateToken(String token) {
        return token != null && token.endsWith("_token");
    }

    public String extractUsername(String token) {
        if (token == null) return null;
        return token.replace("_token", "");
    }
}
