// package com.example.demo.repository;
// import org.springframework.data.jpa.repsoitory.JpaRepository;
// import org.springframework.stereotype.Repository;
// import com.example.demo.entity.ApiUsageLogRepository;
// @Repository
// public interface ApiUsageLogRepository extends JpaRepository<ApiUsageLogRepository,Integer>{

// }

package com.example.demo.repository;

import com.example.demo.entity.ApiUsageLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.Instant;
import java.util.List;

@Repository
public interface ApiUsageLogRepository extends JpaRepository<ApiUsageLog, Long> {
    List<ApiUsageLog> findByApiKey_Id(Long id);
    
    @Query("SELECT a FROM ApiUsageLog a WHERE a.apiKey.id = :keyId AND a.timestamp BETWEEN :start AND :end")
    List<ApiUsageLog> findForKeyBetween(@Param("keyId") Long keyId, @Param("start") Instant start, @Param("end") Instant end);
    
    @Query("SELECT COUNT(a) FROM ApiUsageLog a WHERE a.apiKey.id = :keyId AND a.timestamp BETWEEN :start AND :end")
    long countForKeyBetween(@Param("keyId") Long keyId, @Param("start") Instant start, @Param("end") Instant end);
}
