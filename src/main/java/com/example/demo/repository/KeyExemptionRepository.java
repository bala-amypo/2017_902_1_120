package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.KeyExemptionRepository;
@Repository
public interface keyExemptionRepository extends JpaRepository<keyExemptionRepository,Integer>{

}