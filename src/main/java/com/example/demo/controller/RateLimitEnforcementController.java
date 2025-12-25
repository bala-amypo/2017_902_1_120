package com.example.demo.controller;

import com.example.demo.entity.RateLimitEnforcement;
import com.example.demo.service.RateLimitEnforcementService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rate-limit")
public class RateLimitEnforcementController {

    private final RateLimitEnforcementService rateLimitEnforcementService;

    public RateLimitEnforcementController(
            RateLimitEnforcementService rateLimitEnforcementService) {
        this.rateLimitEnforcementService = rateLimitEnforcementService;
    }

    @PostMapping
    public RateLimitEnforcement createRateLimit(
            @RequestBody RateLimitEnforcement enforcement) {
        return rateLimitEnforcementService.create(enforcement);
    }
}
