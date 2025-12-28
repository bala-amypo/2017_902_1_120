package com.example.demo.service.impl;

import com.example.demo.entity.KeyExemption;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ApiKeyRepository;
import com.example.demo.repository.KeyExemptionRepository;
import com.example.demo.service.KeyExemptionService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class KeyExemptionServiceImpl implements KeyExemptionService {

    private final KeyExemptionRepository keyExemptionRepository;
    private final ApiKeyRepository apiKeyRepository;

    public KeyExemptionServiceImpl(KeyExemptionRepository keyExemptionRepository, ApiKeyRepository apiKeyRepository) {
        this.keyExemptionRepository = keyExemptionRepository;
        this.apiKeyRepository = apiKeyRepository;
    }

    @Override
    public KeyExemption createExemption(KeyExemption exemption) {
        if (exemption.getTemporaryExtensionLimit() != null && exemption.getTemporaryExtensionLimit() < 0) {
            throw new BadRequestException("Temporary extension limit must be >= 0");
        }
        
        if (exemption.getValidUntil() != null && exemption.getValidUntil().isBefore(Instant.now())) {
            throw new BadRequestException("Valid until must be in the future");
        }
        
        if (exemption.getApiKey() != null && exemption.getApiKey().getId() != null) {
            apiKeyRepository.findById(exemption.getApiKey().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("ApiKey not found"));
        }
        
        return keyExemptionRepository.save(exemption);
    }

    @Override
    public KeyExemption updateExemption(Long id, KeyExemption exemption) {
        KeyExemption existing = keyExemptionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("KeyExemption not found"));
        
        if (exemption.getTemporaryExtensionLimit() != null && exemption.getTemporaryExtensionLimit() < 0) {
            throw new BadRequestException("Temporary extension limit must be >= 0");
        }
        
        if (exemption.getValidUntil() != null && exemption.getValidUntil().isBefore(Instant.now())) {
            throw new BadRequestException("Valid until must be in the future");
        }
        
        existing.setNotes(exemption.getNotes());
        existing.setUnlimitedAccess(exemption.getUnlimitedAccess());
        existing.setTemporaryExtensionLimit(exemption.getTemporaryExtensionLimit());
        existing.setValidUntil(exemption.getValidUntil());
        
        return keyExemptionRepository.save(existing);
    }

    @Override
    public KeyExemption getExemptionByKey(Long apiKeyId) {
        return keyExemptionRepository.findByApiKey_Id(apiKeyId)
                .orElseThrow(() -> new ResourceNotFoundException("KeyExemption not found"));
    }

    @Override
    public List<KeyExemption> getAllExemptions() {
        return keyExemptionRepository.findAll();
    }
}

