// package com.example.demo.repository;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
// import com.example.demo.entity.RateLimitEnforcementRepository;
// @Repository
// public interface RateLimitEnforcementRepository extends JpaRepository<RateLimitEnforcementRepository,Integer>{
    
// }

package com.example.demo.repository;

import com.example.demo.entity.RateLimitEnforcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RateLimitEnforcementRepository extends JpaRepository<RateLimitEnforcement, Long> {
    List<RateLimitEnforcement> findByApiKey_Id(Long id);
}