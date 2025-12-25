package com.example.demo.controller;

import com.example.demo.entity.KeyExemption;
import com.example.demo.service.KeyExemptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/key-exemptions")
public class KeyExemptionController {

    private final KeyExemptionService keyExemptionService;

    public KeyExemptionController(KeyExemptionService keyExemptionService) {
        this.keyExemptionService = keyExemptionService;
    }

    @GetMapping
    public List<KeyExemption> getAll() {
        return keyExemptionService.getAllExemptions();
    }

    @PostMapping
    public KeyExemption create(@RequestBody KeyExemption exemption) {
        return keyExemptionService.create(exemption);
    }
}
