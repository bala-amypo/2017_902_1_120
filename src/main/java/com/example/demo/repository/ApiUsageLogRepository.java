package com.example.demo.repository;
import org.springframework.data.jpa.repsoitory.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.ApiUsageLogRepository;
@Repository
public interface ApiUsageLogRepository extends JpaRepository<ApiUsageLogRepository,Integer>{
    
    
}