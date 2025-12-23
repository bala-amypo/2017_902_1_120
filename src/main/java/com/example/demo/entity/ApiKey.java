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

@Entity
@Table(name = "api_key")
public class ApiKey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String keyValue;

    private boolean active = true;


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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
