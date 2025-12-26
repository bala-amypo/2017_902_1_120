package com.example.demo.service;

import com.example.demo.entity.KeyExemption;
import java.util.List;

public interface KeyExemptionService {

    List<KeyExemption> getAllExemptions();

    KeyExemption create(KeyExemption exemption);
}
