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
    public void setId(String id){
        this.id=id;
    }
    public String planName(){

    }
    public void
}