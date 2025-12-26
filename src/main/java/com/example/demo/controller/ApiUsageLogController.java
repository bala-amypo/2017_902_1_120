package com.example.demo.controller;

import com.example.demo.entity.ApiUsageLog;
import com.example.demo.service.ApiUsageLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usage")
public class ApiUsageLogController {

    private final ApiUsageLogService service;

    public ApiUsageLogController(ApiUsageLogService service) {
        this.service = service;
    }

    @PostMapping
    public ApiUsageLog log(@RequestBody ApiUsageLog log) {
        return service.logUsage(log);
    }

    @GetMapping("/{keyId}")
    public List<ApiUsageLog> get(@PathVariable Long keyId) {
        return service.getUsageForApiKey(keyId);
    }
}
