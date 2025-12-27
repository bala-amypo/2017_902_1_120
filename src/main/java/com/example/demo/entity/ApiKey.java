// package com.example.demo.entity;
// import jakarta.persistence.*;
// import java.time.*;
// @Entity
// public class ApiKey{
//     // @ManyToOneQuotaPlan
//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;

//     @Column(unique=true)
//     private String keyValue;
//     private Long ownerId;
//     private Boolean active;

//     @ManyToOne
//     @JoinColumn(name="plan_id")
//     private QuotaPlan plan;
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
import java.time.LocalDateTime;

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
    @JoinColumn(name = "plan_id", nullable = false)
    private QuotaPlan plan;

    @Column(nullable = false)
    private Boolean active = true;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ApiKey() {}

    public ApiKey(String keyValue, Long ownerId, QuotaPlan plan, Boolean active) {
        this.keyValue = keyValue;
        this.ownerId = ownerId;
        this.plan = plan;
        this.active = active;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getKeyValue() { return keyValue; }
    public void setKeyValue(String keyValue) { this.keyValue = keyValue; }

    public Long getOwnerId() { return ownerId; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }

    public QuotaPlan getPlan() { return plan; }
    public void setPlan(QuotaPlan plan) { this.plan = plan; }

    public Boolean isActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
