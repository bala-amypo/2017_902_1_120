package com.example.demo.entity;
import jakarta.persistence.*;
@Entity
public class UserAccount{
    @ManyToManyQuotaPlan
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String role;
    private String quotaPlans;

    public Long getId(){
        return id;
    }
    public void setId()
}