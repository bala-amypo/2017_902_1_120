// package com.example.demo.service.impl;

// import com.example.demo.entity.ApiKey;
// import com.example.demo.repository.ApiKeyRepository;
// import com.example.demo.service.ApiKeyService;
// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.UUID;

// @Service
// public class ApiKeyServiceImpl implements ApiKeyService {

//     private final ApiKeyRepository apiKeyRepository;

//     public ApiKeyServiceImpl(ApiKeyRepository apiKeyRepository) {
//         this.apiKeyRepository = apiKeyRepository;
//     }

//     @Override
//     public ApiKey createKey() {
//         ApiKey apiKey = new ApiKey();
//         apiKey.setKeyValue(UUID.randomUUID().toString());
//         return apiKeyRepository.save(apiKey);
//     }

//     @Override
//     public List<ApiKey> getAll() {
//         return apiKeyRepository.findAll();
//     }

//     @Override
//     public void deactivate(Long id) {
//         ApiKey apiKey = apiKeyRepository.findById(id).orElseThrow();
//         apiKey.setActive(false);
//         apiKeyRepository.save(apiKey);
//     }
// }

package com.example.demo.service.impl;

import com.example.demo.entity.ApiKey;
import com.example.demo.repository.ApiKeyRepository;
import com.example.demo.service.ApiKeyService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
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
        apiKey.setCreatedAt(Timestamp.from(Instant.now()));
        apiKey.setUpdatedAt(Timestamp.from(Instant.now()));
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
        apiKey.setUpdatedAt(Timestamp.from(Instant.now()));
        apiKeyRepository.save(apiKey);
    }
}
