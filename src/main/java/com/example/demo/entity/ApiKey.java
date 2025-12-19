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
    public String getKeyValue(){
        return keyValue;
    }
    public void setKeyValue(String KeyValue){
        this.keyValue=keyValue;
    }
    public int getOwnerId(){
        return ownerId;
    }
    public void setOwnerId(long ownerId){
        this.ownerId=ownerId;
    }
    public Boolean getActive(){
        return active;
    }
    public void setActive(Boolean active){
        this.active=active;
    }
}