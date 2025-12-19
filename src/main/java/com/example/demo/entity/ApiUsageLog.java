package com.example.demo.entity;
import jakarta.persistence.*;
import java.time.*;

@Entity
public class ApiUsageLog{
    @ManyToOneApikey
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String apiKey;
    private String endpoint;
    private Timestamp timestamp;

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
    public String getEndpoint(){
        return endpoint;
    }
    public void setEndPoint(String){
        this.enpoint=enpoint;
    }
    public Timestamp getTimeStamp(){
        return 
    }
}