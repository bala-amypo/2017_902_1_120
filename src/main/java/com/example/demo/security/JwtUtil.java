package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Component   // 🔥 THIS IS THE KEY FIX
public class JwtUtil {

    private static final long EXPIRATION_MILLIS = 1000 * 60 * 60; // 1 hour
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // ===============================
    // Generate Token
    // ===============================
    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MILLIS))
                .signWith(key)
                .compact();
    }

    // ===============================
    // Extract Claims
    // ===============================
    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // ===============================
    // Extract Username
    // ===============================
    public String getUsername(String token) {
        return getClaims(token).getSubject();
    }

    // ===============================
    // Validate Token
    // ===============================
    public boolean isTokenValid(String token, String username) {
        return username.equals(getUsername(token)) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

    // ===============================
    // Expiration (used in tests)
    // ===============================
    public long getExpirationMillis() {
        return EXPIRATION_MILLIS;
    }
}
