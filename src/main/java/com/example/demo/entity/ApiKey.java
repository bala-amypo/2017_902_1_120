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
import java.time.LocalDateTime;

@Entity
@Table(
    name = "api_key",
    uniqueConstraints = @UniqueConstraint(columnNames = "key_value")
)
public class ApiKey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "key_value", nullable = false, unique = true)
    private String keyValue;

    @Column(nullable = false)
    private Long ownerId;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private QuotaPlan plan;

    @Column(nullable = false)
    private boolean active = true;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // ✅ GETTERS & SETTERS (VERY IMPORTANT)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public QuotaPlan getPlan() {
        return plan;
    }

    public void setPlan(QuotaPlan plan) {
        this.plan = plan;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
