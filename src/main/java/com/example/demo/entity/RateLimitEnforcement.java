package com.example.demo.entity;
import jakarta.persistence.*;
@Entity
public class RateLimitEnforcement{
    @ManyToOneApiKey
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String apiKey;
    private Timestamp blockedAt;
    private Integer limitExceededBy;
    private String message;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getApiKey(){
        return apiKey;
    }
    public void setApiKey(String apiKey){
        this.apiKey=apiKey;
    }
    public Timestamp getBlockedAt(){
        return blockedAt;
    }
    public void setBlockedAt(Timestamp){
        this.blockedAt=blocked
    }
}