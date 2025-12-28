// package com.example.demo.controller;

// import com.example.demo.entity.ApiUsageLog;
// import com.example.demo.service.ApiUsageLogService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/usage-logs")
// public class ApiUsageLogController {

//     private final ApiUsageLogService apiUsageLogService;

//     public ApiUsageLogController(ApiUsageLogService apiUsageLogService) {
//         this.apiUsageLogService = apiUsageLogService;
//     }

//     @PostMapping
//     public ResponseEntity<ApiUsageLog> logUsage(@RequestBody ApiUsageLog log) {
//         ApiUsageLog saved = apiUsageLogService.logUsage(log);
//         return ResponseEntity.ok(saved);
//     }

//     @GetMapping("/key/{keyId}")
//     public ResponseEntity<List<ApiUsageLog>> getUsageForApiKey(@PathVariable Long keyId) {
//         List<ApiUsageLog> logs = apiUsageLogService.getUsageForApiKey(keyId);
//         return ResponseEntity.ok(logs);
//     }

//     @GetMapping("/key/{keyId}/today")
//     public ResponseEntity<List<ApiUsageLog>> getUsageForToday(@PathVariable Long keyId) {
//         List<ApiUsageLog> logs = apiUsageLogService.getUsageForToday(keyId);
//         return ResponseEntity.ok(logs);
//     }

//     @GetMapping("/key/{keyId}/count-today")
//     public ResponseEntity<Integer> countRequestsToday(@PathVariable Long keyId) {
//         int count = apiUsageLogService.countRequestsToday(keyId);
//         return ResponseEntity.ok(count);
//     }
// }

