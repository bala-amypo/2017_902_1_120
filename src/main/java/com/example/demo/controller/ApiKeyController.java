package com.example.demo.controller;

import com.example.demo.entity.ApiKey;
import com.example.demo.service.ApiKeyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ApiKey> createApiKey(@RequestBody ApiKey apiKey) {
        ApiKey created = apiKeyService.createApiKey(apiKey);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiKey> getApiKeyById(@PathVariable Long id) {
        return ResponseEntity.ok(apiKeyService.getApiKeyById(id));
    }

    @GetMapping("/value/{keyValue}")
    public ResponseEntity<ApiKey> getApiKeyByValue(@PathVariable String keyValue) {
        return ResponseEntity.ok(apiKeyService.getApiKeyByValue(keyValue));
    }


    @GetMapping
    public ResponseEntity<List<ApiKey>> getAllApiKeys() {
        return ResponseEntity.ok(apiKeyService.getAllApiKeys());
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivateApiKey(@PathVariable Long id) {
        apiKeyService.deactivateApiKey(id);
        return ResponseEntity.noContent().build();
    }
}
