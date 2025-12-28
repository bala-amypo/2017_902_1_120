// package com.example.demo.service.impl;

// import com.example.demo.entity.RateLimitEnforcement;
// import com.example.demo.exception.BadRequestException;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.repository.ApiKeyRepository;
// import com.example.demo.repository.RateLimitEnforcementRepository;
// import com.example.demo.service.RateLimitEnforcementService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class RateLimitEnforcementServiceImpl implements RateLimitEnforcementService {

//     private final RateLimitEnforcementRepository rateLimitEnforcementRepository;
//     private final ApiKeyRepository apiKeyRepository;

//     public RateLimitEnforcementServiceImpl(RateLimitEnforcementRepository rateLimitEnforcementRepository,
//                                           ApiKeyRepository apiKeyRepository) {
//         this.rateLimitEnforcementRepository = rateLimitEnforcementRepository;
//         this.apiKeyRepository = apiKeyRepository;
//     }

//     @Override
//     public RateLimitEnforcement createEnforcement(RateLimitEnforcement enforcement) {
//         if (enforcement.getLimitExceededBy() < 1) {
//             throw new BadRequestException("Limit exceeded by must be >= 1");
//         }
        
//         if (enforcement.getApiKey() != null && enforcement.getApiKey().getId() != null) {
//             apiKeyRepository.findById(enforcement.getApiKey().getId())
//                     .orElseThrow(() -> new ResourceNotFoundException("ApiKey not found"));
//         }
        
//         return rateLimitEnforcementRepository.save(enforcement);
//     }

//     @Override
//     public RateLimitEnforcement getEnforcementById(Long id) {
//         return rateLimitEnforcementRepository.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("RateLimitEnforcement not found"));
//     }

//     @Override
//     public List<RateLimitEnforcement> getEnforcementsForKey(Long keyId) {
//         return rateLimitEnforcementRepository.findByApiKey_Id(keyId);
//     }
// }

package com.example.demo.service.impl;

import com.example.demo.entity.RateLimitEnforcement;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ApiKeyRepository;
import com.example.demo.repository.RateLimitEnforcementRepository;
import com.example.demo.service.RateLimitEnforcementService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RateLimitEnforcementServiceImpl implements RateLimitEnforcementService {

    private final RateLimitEnforcementRepository rateLimitEnforcementRepository;
    private final ApiKeyRepository apiKeyRepository;

    public RateLimitEnforcementServiceImpl(RateLimitEnforcementRepository rateLimitEnforcementRepository,
                                          ApiKeyRepository apiKeyRepository) {
        this.rateLimitEnforcementRepository = rateLimitEnforcementRepository;
        this.apiKeyRepository = apiKeyRepository;
    }

    @Override
    public RateLimitEnforcement createEnforcement(RateLimitEnforcement enforcement) {
        if (enforcement.getLimitExceededBy() < 1) {
            throw new BadRequestException("Limit exceeded by must be >= 1");
        }
        
        if (enforcement.getApiKey() != null && enforcement.getApiKey().getId() != null) {
            apiKeyRepository.findById(enforcement.getApiKey().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("ApiKey not found"));
        }
        
        return rateLimitEnforcementRepository.save(enforcement);
    }

    @Override
    public RateLimitEnforcement getEnforcementById(Long id) {
        return rateLimitEnforcementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RateLimitEnforcement not found"));
    }

    @Override
    public List<RateLimitEnforcement> getEnforcementsForKey(Long keyId) {
        return rateLimitEnforcementRepository.findByApiKey_Id(keyId);
    }
}