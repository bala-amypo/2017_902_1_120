package com.example.demo.service.impl;

import com.example.demo.entity.ApiUsageLog;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ApiKeyRepository;
import com.example.demo.repository.ApiUsageLogRepository;
import com.example.demo.service.ApiUsageLogService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;

@Service
public class ApiUsageLogServiceImpl implements ApiUsageLogService {

    private final ApiUsageLogRepository apiUsageLogRepository;
    private final ApiKeyRepository apiKeyRepository;

    public ApiUsageLogServiceImpl(ApiUsageLogRepository apiUsageLogRepository, ApiKeyRepository apiKeyRepository) {
        this.apiUsageLogRepository = apiUsageLogRepository;
        this.apiKeyRepository = apiKeyRepository;
    }

    @Override
    public ApiUsageLog logUsage(ApiUsageLog log) {
        if (log.getTimestamp().isAfter(Instant.now())) {
            throw new BadRequestException("Timestamp cannot be in the future");
        }
        
        if (log.getApiKey() != null && log.getApiKey().getId() != null) {
            apiKeyRepository.findById(log.getApiKey().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("ApiKey not found"));
        }
        
        return apiUsageLogRepository.save(log);
    }

    @Override
    public List<ApiUsageLog> getUsageForApiKey(Long keyId) {
        return apiUsageLogRepository.findByApiKey_Id(keyId);
    }

    @Override
    public List<ApiUsageLog> getUsageForToday(Long keyId) {
        LocalDate today = LocalDate.now();
        Instant start = today.atStartOfDay().toInstant(ZoneOffset.UTC);
        Instant end = today.plusDays(1).atStartOfDay().toInstant(ZoneOffset.UTC);
        
        return apiUsageLogRepository.findForKeyBetween(keyId, start, end);
    }

    @Override
    public int countRequestsToday(Long keyId) {
        LocalDate today = LocalDate.now();
        Instant start = today.atStartOfDay().toInstant(ZoneOffset.UTC);
        Instant end = today.plusDays(1).atStartOfDay().toInstant(ZoneOffset.UTC);
        
        return apiUsageLogRepository.countForKeyBetween(keyId, start, end);
    }
}

