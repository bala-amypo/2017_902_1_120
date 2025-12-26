package com.example.demo.service.impl;

import com.example.demo.entity.KeyExemption;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ApiKeyRepository;
import com.example.demo.repository.KeyExemptionRepository;
import com.example.demo.service.KeyExemptionService;

import java.time.Instant;
import java.util.List;

public class KeyExemptionServiceImpl implements KeyExemptionService {

    private final KeyExemptionRepository repo;
    private final ApiKeyRepository keyRepo;

    public KeyExemptionServiceImpl(KeyExemptionRepository repo, ApiKeyRepository keyRepo) {
        this.repo = repo;
        this.keyRepo = keyRepo;
    }

    @Override
    public KeyExemption createExemption(KeyExemption ex) {
        if (ex.getTemporaryExtensionLimit() < 0) {
            throw new BadRequestException("Invalid extension");
        }
        if (ex.getValidUntil().isBefore(Instant.now())) {
            throw new BadRequestException("Invalid expiry");
        }
        return repo.save(ex);
    }

    @Override
    public KeyExemption getExemptionByKey(Long keyId) {
        return repo.findByApiKey_Id(keyId)
                .orElseThrow(() -> new ResourceNotFoundException("Exemption not found"));
    }

    @Override
    public List<KeyExemption> getAllExemptions() {
        return repo.findAll();
    }
}
