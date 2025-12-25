// package com.example.demo.service.impl;

// import com.example.demo.entity.RateLimitEnforcement;
// import com.example.demo.repository.RateLimitEnforcementRepository;
// import com.example.demo.service.RateLimitEnforcementService;
// import org.springframework.stereotype.Service;

// @Service
// public class RateLimitEnforcementServiceImpl implements RateLimitEnforcementService {

//     private final RateLimitEnforcementRepository repository;

//     public RateLimitEnforcementServiceImpl(RateLimitEnforcementRepository repository) {
//         this.repository = repository;
//     }

//     @Override
//     public RateLimitEnforcement create(RateLimitEnforcement enforcement) {
//         return repository.save(enforcement);
//     }
// }

package com.example.demo.service.impl;

import com.example.demo.entity.RateLimitEnforcement;
import com.example.demo.repository.RateLimitEnforcementRepository;
import com.example.demo.service.RateLimitEnforcementService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class RateLimitEnforcementServiceImpl implements RateLimitEnforcementService {

    private final RateLimitEnforcementRepository rateLimitEnforcementRepository;

    public RateLimitEnforcementServiceImpl(
            RateLimitEnforcementRepository rateLimitEnforcementRepository) {
        this.rateLimitEnforcementRepository = rateLimitEnforcementRepository;
    }

    @Override
    public RateLimitEnforcement create(RateLimitEnforcement enforcement) {

        // set blocked time automatically
        enforcement.setBlockedAt(new Timestamp(System.currentTimeMillis()));

        return rateLimitEnforcementRepository.save(enforcement);
    }
}
