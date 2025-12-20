// package com.example.demo.entity;
// import jakarta.persistence.*;
// import java.time.*;
// @Entity
// public class ApiKey{
//     @ManyToOneQuotaPlan
//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;
//     private String keyValue;
//     private Long ownerId;
//     private Boolean active;
//     private String plan;
//     private Timestamp createdAt;
//     private Timestamp updatedAt;


//     public Long getId(){
//         return id;
//     }
//     public void setId(Long id){
//         this.id=id;
//     }
//     public String getKeyValue(){
//         return keyValue;
//     }
//     public void setKeyValue(String KeyValue){
//         this.keyValue=keyValue;
//     }
//     public int getOwnerId(){
//         return ownerId;
//     }
//     public void setOwnerId(long ownerId){
//         this.ownerId=ownerId;
//     }
//     public Boolean getActive(){
//         return active;
//     }
//     public void setActive(Boolean active){
//         this.active=active;
//     }
//     public Timestamp getCreatedAt(){
//         return createdAt;
//     }
//     public void setCreatedAt(Timestamp createdAt){
//         this.createdAt=createdAt;
//     }
//     public Timestamp getUpdatedAt(){
//         return updatedAt;
//     }
//     public void setUpdatedAt(Timestamp updatedAt){
//         this.updatedAt=updatedAt;
//     }
//     public ApiKey(Long id,String keyValue,Long ownerId,Boolean active,Timestamp createdAt,Timestamp updatedAt){
//         this.id=id;
//         this.keyValue=keyValue;
//         this.ownerId=ownerId;
//         this.active=active;
//         this.createdAt=createdAt;
//         this.updatedAt=updatedAt;
//     }
//     public ApiKey(){

//     }
// }

package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "api_keys")
public class ApiKey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String keyValue;

    @Column(nullable = false)
    private Long ownerId;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private QuotaPlan plan;

    @Column(nullable = false)
    private Boolean active = true;

    @Column(nullable = false)
    private Instant createdAt = Instant.now();

    private Instant updatedAt = Instant.now();

    public ApiKey() {}

    public ApiKey(String keyValue, Long ownerId, QuotaPlan plan) {
        this.keyValue = keyValue;
        this.ownerId = ownerId;
        this.plan = plan;
        this.active = true;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

   
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getKeyValue() { return keyValue; }
    public void setKeyValue(String keyValue) { this.keyValue = keyValue; }

    public Long getOwnerId() { return ownerId; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }

    public QuotaPlan getPlan() { return plan; }
    public void setPlan(QuotaPlan plan) { this.plan = plan; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    public Instant getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }
}