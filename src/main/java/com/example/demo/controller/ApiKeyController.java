package com.example.demo.controller;

import com.example.demo.entity.ApiKey;
import com.example.demo.service.ApiKeyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/api-keys")
public class ApiKeyController {

    private final ApiKeyService apiKeyService;

    public ApiKeyController(ApiKeyService apiKeyService) {
        this.apiKeyService = apiKeyService;
    }

    @PostMapping
    public ApiKey createApiKey() {
        return apiKeyService.createKey();
    }

    @GetMapping
    public List<ApiKey> getAllApiKeys() {
        return apiKeyService.getAll();
    }

    @PutMapping("/{id}/deactivate")
    public void deactivateApiKey(@PathVariable Long id) {
        apiKeyService.deactivate(id);
    }
}
