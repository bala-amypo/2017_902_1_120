package com.example.demo.controller;

import com.example.demo.entity.RateLimitEnforcement;
import com.example.demo.service.RateLimitEnforcementService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enforcements")
public class RateLimitEnforcementController {

    private final RateLimitEnforcementService rateLimitEnforcementService;

    public RateLimitEnforcementController(RateLimitEnforcementService rateLimitEnforcementService) {
        this.rateLimitEnforcementService = rateLimitEnforcementService;
    }

    @PostMapping
    public RateLimitEnforcement createEnforcement(
            @RequestBody RateLimitEnforcement enforcement) {
        return rateLimitEnforcementService.create(enforcement);
    }
}
