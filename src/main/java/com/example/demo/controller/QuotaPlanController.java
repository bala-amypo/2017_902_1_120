// package com.example.demo.controller;

// import com.example.demo.entity.QuotaPlan;
// import com.example.demo.service.QuotaPlanService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/quota-plans")
// public class QuotaPlanController {

//     private final QuotaPlanService quotaPlanService;

//     public QuotaPlanController(QuotaPlanService quotaPlanService) {
//         this.quotaPlanService = quotaPlanService;
//     }

//     @PostMapping
//     public ResponseEntity<QuotaPlan> createQuotaPlan(@RequestBody QuotaPlan plan) {
//         QuotaPlan created = quotaPlanService.createQuotaPlan(plan);
//         return ResponseEntity.ok(created);
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<QuotaPlan> updateQuotaPlan(@PathVariable Long id, @RequestBody QuotaPlan plan) {
//         QuotaPlan updated = quotaPlanService.updateQuotaPlan(id, plan);
//         return ResponseEntity.ok(updated);
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<QuotaPlan> getQuotaPlanById(@PathVariable Long id) {
//         QuotaPlan plan = quotaPlanService.getQuotaPlanById(id);
//         return ResponseEntity.ok(plan);
//     }

//     @GetMapping
//     public ResponseEntity<List<QuotaPlan>> getAllPlans() {
//         List<QuotaPlan> plans = quotaPlanService.getAllPlans();
//         return ResponseEntity.ok(plans);
//     }

//     @PutMapping("/{id}/deactivate")
//     public ResponseEntity<Void> deactivateQuotaPlan(@PathVariable Long id) {
//         quotaPlanService.deactivateQuotaPlan(id);
//         return ResponseEntity.ok().build();
//     }
// }