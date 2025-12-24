package com.example.demo.entity;
import jakarta.persistence.*;
import java.time.*;

@Entity
public class ApiUsageLog{
    // @ManyToOneApikey
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "api_key_id")
    private ApiKey apiKey;
    
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
        return timestamp;
    }
    public void setTimeStamp(){
        this.timestamp=timestamp;
    }
    public ApiUsageLog(Long id,String apiKey,String endpoint,Timestamp timestamp){
        this.id=id;
        this.apiKey=apiKey;
        this.endpoint=endpoint;
        this.timestamp=timestamp;
    }
    public ApiUsageLog(){
        
    }


