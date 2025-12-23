// package com.example.demo.service.impl;

// import com.example.demo.entity.RateLimitEnforcement;
// import com.example.demo.repository.RateLimitEnforcementRepository;
// import com.example.demo.service.RateLimitEnforcementService;
// import org.springframework.stereotype.Service;

// @Service
// public class RateLimitEnforcementServiceImpl
//         implements RateLimitEnforcementService {

//     private final RateLimitEnforcementRepository repository;

//     public RateLimitEnforcementServiceImpl(
//             RateLimitEnforcementRepository repository) {
//         this.repository = repository;
//     }

//     @Override
//     public RateLimitEnforcement create(RateLimitEnforcement enforcement) {
//         return repository.save(enforcement);
//     }
// }

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
//     public RateLimitEnforcement save(RateLimitEnforcement enforcement) {
//         return repository.save(enforcement);
//     }
// }

@Service
public class RateLimitEnforcementServiceImpl implements RateLimitEnforcementService {

    @Override
    public RateLimitEnforcement create(RateLimitEnforcement enforcement) {
        enforcement.setBlockedAt(LocalDateTime.now());
        return repository.save(enforcement);
    }
}




