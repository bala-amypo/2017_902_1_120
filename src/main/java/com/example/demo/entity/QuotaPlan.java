package com.example.demo.entity;
import jakarta.persistence.*;
@Entity
public class QuotaPlan{
    @Id
    private Long id;
    private String planName;
    private Integer dailyLimit;
    private String description;
    private Boolean active;
    
    public long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getPlanName(){
         return planName;
    }
    public void setPlanName(String planName){
        this.planName=planName;
    }
    public Integer getDailyLimit(){
        return dailyLimit;
    }
    public void setDailyLimit(Integer dailyLimit){
        this.dailyLimit=dailyLimit;
    }
    public String getDescription(){
        return description;
    }
    public String setDescription(String description ){
        this.description=description;
    }
    public Boolean getActive(){
        return active;
    }
    public void setActive(Boolean active){
        this.active=active;
    }
    public QuotaPlan(Long id,String planName,String dailyLimit,String description,Boolean active)
}
