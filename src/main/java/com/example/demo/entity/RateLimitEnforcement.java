package com.example.demo.entity;
import jakarta.persistence.*;
@Entity
public class RateLimitEnforcement{
    @ManyToOneApiKey
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String apiKey;
    private String endpoint;
    private Timestamp timestamp;

    public Long getId(){
        return id;
    }
    public 
}