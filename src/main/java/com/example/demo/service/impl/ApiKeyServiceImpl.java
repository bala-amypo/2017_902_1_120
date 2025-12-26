package com.example.demo.service.impl;

import com.example.demo.entity.ApiKey;
import com.example.demo.entity.QuotaPlan;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ApiKeyRepository;
import com.example.demo.repository.QuotaPlanRepository;
import com.example.demo.service.ApiKeyService;

import java.util.List;

public class ApiKeyServiceImpl implements ApiKeyService {

    private final ApiKeyRepository repo;
    private final QuotaPlanRepository planRepo;

    public ApiKeyServiceImpl(ApiKeyRepository repo, QuotaPlanRepository planRepo) {
        this.repo = repo;
        this.planRepo = planRepo;
    }

    @Override
    public ApiKey createApiKey(ApiKey key) {
        QuotaPlan plan = planRepo.findById(key.getPlan().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Plan not found"));

        if (!plan.isActive()) {
            throw new BadRequestException("Plan inactive");
        }

        return repo.save(key);
    }

    @Override
    public ApiKey getApiKeyById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ApiKey not found"));
    }

    @Override
    public ApiKey getApiKeyByValue(String value) {
        return repo.findByKeyValue(value)
                .orElseThrow(() -> new ResourceNotFoundException("ApiKey not found"));
    }

    @Override
    public List<ApiKey> getAllApiKeys() {
        return repo.findAll();
    }

    @Override
    public void deactivateApiKey(Long id) {
        ApiKey key = getApiKeyById(id);
        key.setActive(false);
    }
}
