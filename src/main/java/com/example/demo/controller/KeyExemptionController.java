package com.example.demo.controller;

import com.example.demo.entity.KeyExemption;
import com.example.demo.service.KeyExemptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/key-exemptions")
public class KeyExemptionController {

    private final KeyExemptionService keyExemptionService;

    public KeyExemptionController(KeyExemptionService keyExemptionService) {
        this.keyExemptionService = keyExemptionService;
    }

    @PostMapping
    public ResponseEntity<KeyExemption> createExemption(@RequestBody KeyExemption exemption) {
        KeyExemption created = keyExemptionService.createExemption(exemption);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<KeyExemption> updateExemption(@PathVariable Long id, @RequestBody KeyExemption exemption) {
        KeyExemption updated = keyExemptionService.updateExemption(id, exemption);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/key/{keyId}")
    public ResponseEntity<KeyExemption> getExemptionByKey(@PathVariable Long keyId) {
        KeyExemption exemption = keyExemptionService.getExemptionByKey(keyId);
        return ResponseEntity.ok(exemption);
    }

    @GetMapping
    public ResponseEntity<List<KeyExemption>> getAllExemptions() {
        List<KeyExemption> exemptions = keyExemptionService.getAllExemptions();
        return ResponseEntity.ok(exemptions);
    }
}

