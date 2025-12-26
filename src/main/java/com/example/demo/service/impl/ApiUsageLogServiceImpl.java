package com.example.demo.service.impl;

import com.example.demo.entity.ApiUsageLog;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.ApiKeyRepository;
import com.example.demo.repository.ApiUsageLogRepository;
import com.example.demo.service.ApiUsageLogService;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;

@Service
public class ApiUsageLogServiceImpl implements ApiUsageLogService {

    private final ApiUsageLogRepository repo;
    private final ApiKeyRepository keyRepo;

    public ApiUsageLogServiceImpl(ApiUsageLogRepository repo, ApiKeyRepository keyRepo) {
        this.repo = repo;
        this.keyRepo = keyRepo;
    }

    @Override
    public ApiUsageLog logUsage(ApiUsageLog log) {
        if (log.getTimestamp().isAfter(Instant.now())) {
            throw new BadRequestException("Future timestamp");
        }
        return repo.save(log);
    }

    @Override
    public List<ApiUsageLog> getUsageForApiKey(Long id) {
        return repo.findByApiKey_Id(id);
    }

    @Override
    public List<ApiUsageLog> getUsageForToday(Long id) {
        Instant start = LocalDate.now().atStartOfDay().toInstant(ZoneOffset.UTC);
        Instant end = start.plusSeconds(86400);
        return repo.findForKeyBetween(id, start, end);
    }

    @Override
    public int countRequestsToday(Long id) {
        Instant start = LocalDate.now().atStartOfDay().toInstant(ZoneOffset.UTC);
        Instant end = start.plusSeconds(86400);
        return repo.countForKeyBetween(id, start, end);
    }
}
