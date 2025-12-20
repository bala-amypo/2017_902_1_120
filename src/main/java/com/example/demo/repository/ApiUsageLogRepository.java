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

public interface ApiUsageLogRepository extends JpaRepository<ApiUsageLog, Long> {
}
