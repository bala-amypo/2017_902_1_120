// package com.example.demo.entity;
// import jakarta.persistence.*;
// import java.time.*;

// @Entity
// public class ApiUsageLog{
//     @ManyToOneApikey
//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;
//     private String apiKey;
//     private String endpoint;
//     private Timestamp timestamp;

//     public Long getId(){
//         return id;
//     }
//     public void setId(Long id){
//         this.id=id;
//     }
//     public String getApiKey(){
//         return apiKey;
//     }
//     public void setApiKey(String apiKey){
//         this.apiKey=apiKey;
//     }
//     public String getEndpoint(){
//         return endpoint;
//     }
//     public void setEndPoint(String){
//         this.enpoint=enpoint;
//     }
//     public Timestamp getTimeStamp(){
//         return timestamp;
//     }
//     public void setTimeStamp(){
//         this.timestamp=timestamp;
//     }
//     public ApiUsageLog(Long id,String apiKey,String endpoint,Timestamp timestamp){
//         this.id=id;
//         this.apiKey=apiKey;
//         this.endpoint=endpoint;
//         this.timestamp=timestamp;
//     }
//     public ApiUsageLog(){
        
//     }
// 

package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class ApiUsageLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String apiKey;

    private LocalDate usageDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public LocalDate getUsageDate() {
        return usageDate;
    }

    public void setUsageDate(LocalDate usageDate) {
        this.usageDate = usageDate;
    }
}
