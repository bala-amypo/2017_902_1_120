package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.*;

@Entity
public class KeyExemption{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String apiKey;
    private String notes;
    private Boolean unlimitedAccess;
    private Integer temporaryExtensionLimit;
    private 
}