// package com.example.demo.entity;
// import jakarta.persistence.*;
// @Entity
// public class RateLimitEnforcement{
//     @ManyToOneApiKey
//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;
//     private String apiKey;
//     private Timestamp blockedAt;
//     private Integer limitExceededBy;
//     private String message;

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
//     public Timestamp getBlockedAt(){
//         return blockedAt;
//     }
//     public void setBlockedAt(Timestamp blockedAt){
//         this.blockedAt=blockedAt;
//     }
//     public Integer getLimitExceededBy(){
//         return limitExceededBy;
//     }
//     public void setLimitExceededBy(Integer limitExceededBy){
//         this.limitExceededBy=limitExceededBy;
//     }
//     public String getMessage(){
//         return message;
//     }
//     public void setMessage(String message){
//         this.message=message;
//     }

//     public RateLimitEnforcement(Long id,String apiKey,Timestamp blockedAt,Integer limitExceededBy,String message){
//         this.id=id;
//         this.apiKey=apiKey;
//         this.blockedAt=blockedAt;
//         this.limitExceededBy=limitExceededBy;
//         this.message=message;
//     }
//     public RateLimitEnforcement(){
        
//     }
// 

package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rate_limit_enforcements")
public class RateLimitEnforcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    private int limitExceededBy;

    private LocalDateTime blockedAt;

    @ManyToOne
    @JoinColumn(name = "api_key_id", nullable = false)
    private ApiKey apiKey;

    
}

