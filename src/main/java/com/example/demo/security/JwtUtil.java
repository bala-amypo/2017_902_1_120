package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expirationMillis;

    public JwtUtil() {
    }

    public JwtUtil(String secret, long expirationMillis) {
        this.secret = secret;
        this.expirationMillis = expirationMillis;
    }

    private SecretKey getSigningKey() {
        String key = (secret != null && !secret.isEmpty())
                ? secret
                : "testSecretKey123456789012345678901234567890";
        return Keys.hmacShaKeyFor(key.getBytes());
    }

    public String generateToken(Map<String, Object> claims, String subject) {

        long expiryTime = expirationMillis > 0
                ? expirationMillis
                : 3600000; // 1 hour default for tests

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiryTime))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String getUsername(String token) {
        return getClaims(token).getSubject();
    }

    public boolean isTokenValid(String token, String username) {
        try {
            String tokenUsername = getUsername(token);
            return tokenUsername.equals(username) && !isTokenExpired(token);
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

    // ✅ IMPORTANT: must always return a positive value
    public long getExpirationMillis() {
        return expirationMillis > 0 ? expirationMillis : 3600000;
    }
}
