package com.relevantz.ccp.util;

//import io.jsonwebtoken.Jwts;
//
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

@Component
public class JwtUtil {
    private final Key key;

    public JwtUtil() {
        // Generate a secure key for HS512 algorithm
        this.key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    }

    public String generateToken(String email, String userType) {
        return Jwts.builder()
                .setSubject(email)
                .claim("userType", userType) // Include user type as a claim
                .signWith(key)
                .compact();
    }
}