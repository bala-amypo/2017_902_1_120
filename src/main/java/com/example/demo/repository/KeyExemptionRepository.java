package com.example.demo.repository;

import com.example.demo.entity.KeyExemption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface KeyExemptionRepository extends JpaRepository<KeyExemption, Long> {
    Optional<KeyExemption> findByApiKey_Id(Long id);
}