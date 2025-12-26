package com.example.demo.controller;

import com.example.demo.entity.ApiKey;
import com.example.demo.service.ApiKeyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/api-keys")
public class ApiKeyController {

    private final ApiKeyService apiKeyService;

    public ApiKeyController(ApiKeyService service) {
        this.service = service;
    }
    @RestController
@RequestMapping("/api/api-keys")
public class ApiKeyController {

    private final ApiKeyService apiKeyService;

    public ApiKeyController(ApiKeyService apiKeyService) {
        this.apiKeyService = apiKeyService;
    }
}


    @PostMapping
    public ApiKey create(@RequestBody ApiKey key) {
        return service.createApiKey(key);
    }

    @GetMapping("/{id}")
    public ApiKey get(@PathVariable Long id) {
        return service.getApiKeyById(id);
    }

    @GetMapping
    public List<ApiKey> getAll() {
        return service.getAllApiKeys();
    }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        service.deactivateApiKey(id);
    }
}
