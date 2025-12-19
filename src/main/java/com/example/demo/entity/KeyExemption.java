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
    public String getApiKey(){
        return apiKey;
    }
    public void setApiKey(String apiKey){
        this.apiKey=apiKey;
    }
    public String getNotes(){
        return notes;
    }
    public void setNotes(String notes){
        this.notes=notes
    }
    public Boolean getUnLimitedAccess(){
        return unlimitedAccess;
    }
    public void setUnLimitedAccess(Boolean unlimitedAccess){
        this.unlimitedAccess=unlimitedAccess;
    }
    public Integer getTemporaryExtensionLimit(){
        return temporaryExtensionLimit;
    }
    public void setTemporaryExtensionLimit(Integer temporaryExtensionLimit){
        this.
    }

}