package com.example.demo.entity;
import jakarta.persistence.*;
import java.time.*;
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
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public string getkeyValue(){
        return keyValue;
    }
    public void setkeyValue
}