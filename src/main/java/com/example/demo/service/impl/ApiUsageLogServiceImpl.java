// package com.example.demo.service.impl;

// import com.example.demo.entity.ApiUsageLog;
// import com.example.demo.repository.ApiUsageLogRepository;
// import com.example.demo.service.ApiUsageLogService;
// import org.springframework.stereotype.Service;

// @Service
// public class ApiUsageLogServiceImpl implements ApiUsageLogService {

//     private final ApiUsageLogRepository apiUsageLogRepository;

//     public ApiUsageLogServiceImpl(ApiUsageLogRepository apiUsageLogRepository) {
//         this.apiUsageLogRepository = apiUsageLogRepository;
//     }

//     @Override
//     public ApiUsageLog logUsage(ApiUsageLog log) {
//         return apiUsageLogRepository.save(log);
//     }
// }

package com.example.demo.service.impl;

import com.example.demo.entity.ApiKey;
import com.example.demo.repository.ApiKeyRepository;
import com.example.demo.service.ApiKeyService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
public class ApiKeyServiceImpl implements ApiKeyService {

    private final ApiKeyRepository apiKeyRepository;

    public ApiKeyServiceImpl(ApiKeyRepository apiKeyRepository) {
        this.apiKeyRepository = apiKeyRepository;
    }

    @Override
    public ApiKey createKey() {
        ApiKey apiKey = new ApiKey();
        apiKey.setKeyValue(UUID.randomUUID().toString());
        apiKey.setActive(true);
        apiKey.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        apiKey.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        return apiKeyRepository.save(apiKey);
    }

    @Override
    public List<ApiKey> getAll() {
        return apiKeyRepository.findAll();
    }

    @Override
    public void deactivate(Long id) {
        ApiKey apiKey = apiKeyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("API Key not found"));
        apiKey.setActive(false);
        apiKey.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        apiKeyRepository.save(apiKey);
    }
}

