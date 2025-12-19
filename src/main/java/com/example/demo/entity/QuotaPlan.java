package com.example.demo.entity;
import jakarta.persistence.*;
@Entity
public class QuotaPlan{
    @Id
    private long id;
    private String planName;
    private Integer dailylimit;
    private String description;
    private Boolean active;
    
    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id=id;
    }
    public String getPlanName(){
         return planName;
    }
    public void setPlanName(String planName){
        this.plan
    }
}