// package com.example.demo.service;

// import com.example.demo.entity.RateLimitEnforcement;

// public interface RateLimitEnforcementService {

//     RateLimitEnforcement create(RateLimitEnforcement enforcement);
// }

package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class RateLimitEnforcement {

    private final ConcurrentHashMap<String, AtomicInteger> requestCounts = new ConcurrentHashMap<>();

    private static final int MAX_REQUESTS = 5;

    public boolean allowRequest(String apiKey) {
        requestCounts.putIfAbsent(apiKey, new AtomicInteger(0));
        int count = requestCounts.get(apiKey).incrementAndGet();
        return count <= MAX_REQUESTS;
    }
}
