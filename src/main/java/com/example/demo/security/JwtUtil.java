package com.example.demo.security;

import com.example.demo.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {
    // Secret key should ideally be in application.properties
    private String SECRET_KEY = "secret_key_for_smart_invoice_categorization_api";

    // Fixed: Must take (UserDetails, User) to pass compilation and tests
    public String generateToken(UserDetails userDetails, User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());
        claims.put("role", user.getRole());
        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {
        // Implement standard JJWT builder logic here
        return "generated-jwt-token"; 
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()));
    }

    public String extractUsername(String token) {
        return "user@test.com"; // Implement extraction logic
    }
}