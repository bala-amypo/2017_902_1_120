package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.*;

@Entity
public class KeyExemption{
    @ManyToOneApiKey
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String apiKey;
    private String notes;
    private Boolean unlimitedAccess;
    private Integer temporaryExtensionLimit;
    private Timestamp validUntil;

    public Long getI(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public 

}