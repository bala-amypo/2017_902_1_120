package com.example.demo.entity;
import jakarta.persistence.*;
@Entity
public class RateLimitEnforcement{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String apiKey;
    private String end
}