// package com.example.demo.entity;

// import jakarta.persistence.*;
// import java.time.*;

// @Entity
// public class KeyExemption{
//     @ManyToOneApiKey
//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;
//     private String apiKey;
//     private String notes;
//     private Boolean unlimitedAccess;
//     private Integer temporaryExtensionLimit;
//     private Timestamp validUntil;

//     public Long getI(){
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
//     public String getNotes(){
//         return notes;
//     }
//     public void setNotes(String notes){
//         this.notes=notes
//     }
//     public Boolean getUnLimitedAccess(){
//         return unlimitedAccess;
//     }
//     public void setUnLimitedAccess(Boolean unlimitedAccess){
//         this.unlimitedAccess=unlimitedAccess;
//     }
//     public Integer getTemporaryExtensionLimit(){
//         return temporaryExtensionLimit;
//     }
//     public void setTemporaryExtensionLimit(Integer temporaryExtensionLimit){
//         this.temporaryExtensionLimit=temporaryExtensionLimit;
//     }
//     public Timestamp getValidUntil(){
//         return validUntil;
//     }
//     public void setValidUntil(Timestamp validUntil){
//         this.validUntil=validUntil;
//     }
//     public KeyExemption(Long id,String apiKey,String notes,Boolean unlimitedAccess,Integer temporaryExtensionLimit,Timestamp validUntil){
//         this.id=id;
//         this.apiKey=apiKey;
//         this.notes=notes;
//         this.unlimitedAccess=unlimitedAccess;
//         this.temporaryExtensionLimit=temporaryExtensionLimit;
//         this.validUntil=validUntil;
//     }
//     public KeyExemption(){
        
//     }

// }

package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "key_exemptions")
public class KeyExemption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "api_key_id", nullable = false)
    private ApiKey apiKey;

    private String notes;

    @Column(nullable = false)
    private Boolean unlimitedAccess = false;

    private Integer temporaryExtensionLimit;

    private Instant validUntil;

    public KeyExemption() {}

    public KeyExemption(ApiKey apiKey, String notes, Boolean unlimitedAccess, Integer temporaryExtensionLimit, Instant validUntil) {
        this.apiKey = apiKey;
        this.notes = notes;
        this.unlimitedAccess = unlimitedAccess;
        this.temporaryExtensionLimit = temporaryExtensionLimit;
        this.validUntil = validUntil;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public ApiKey getApiKey() { return apiKey; }
    public void setApiKey(ApiKey apiKey) { this.apiKey = apiKey; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public Boolean getUnlimitedAccess() { return unlimitedAccess; }
    public void setUnlimitedAccess(Boolean unlimitedAccess) { this.unlimitedAccess = unlimitedAccess; }

    public Integer getTemporaryExtensionLimit() { return temporaryExtensionLimit; }
    public void setTemporaryExtensionLimit(Integer temporaryExtensionLimit) { this.temporaryExtensionLimit = temporaryExtensionLimit; }

    public Instant getValidUntil() { return validUntil; }
    public void setValidUntil(Instant validUntil) { this.validUntil = validUntil; }
}