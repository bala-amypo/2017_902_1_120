package com.example.demo.entity;
import jakarta.persistence.*;
@Entity
public class ApiKey{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String keyValue;
    private Long ownerId;
    private Boolean active;
    private TimeStamp createdAt;
    private TimeStamp updatedAt;

    public int getId(){
        
    }
}