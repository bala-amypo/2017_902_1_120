package com.example.demo.entity;
import jakarta.persistence.*;
import java.Time.*;

@Entity
public class ApiUsageLog{
    @ManyToOneApikey
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String apiKey;
    private String endpoint;
    private Timestamp timestamp;
}