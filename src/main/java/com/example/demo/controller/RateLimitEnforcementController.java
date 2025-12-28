// package com.example.demo.controller;

// import com.example.demo.entity.RateLimitEnforcement;
// import com.example.demo.service.RateLimitEnforcementService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/enforcements")
// public class RateLimitEnforcementController {

//     private final RateLimitEnforcementService rateLimitEnforcementService;

//     public RateLimitEnforcementController(RateLimitEnforcementService rateLimitEnforcementService) {
//         this.rateLimitEnforcementService = rateLimitEnforcementService;
//     }

//     @PostMapping
//     public ResponseEntity<RateLimitEnforcement> createEnforcement(@RequestBody RateLimitEnforcement enforcement) {
//         RateLimitEnforcement created = rateLimitEnforcementService.createEnforcement(enforcement);
//         return ResponseEntity.ok(created);
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<RateLimitEnforcement> getEnforcementById(@PathVariable Long id) {
//         RateLimitEnforcement enforcement = rateLimitEnforcementService.getEnforcementById(id);
//         return ResponseEntity.ok(enforcement);
//     }

//     @GetMapping("/key/{keyId}")
//     public ResponseEntity<List<RateLimitEnforcement>> getEnforcementsForKey(@PathVariable Long keyId) {
//         List<RateLimitEnforcement> enforcements = rateLimitEnforcementService.getEnforcementsForKey(keyId);
//         return ResponseEntity.ok(enforcements);
//     }
// }