// package com.example.demo.controller;

// import com.example.demo.entity.KeyExemption;
// import com.example.demo.service.KeyExemptionService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/key-exemptions")
// public class KeyExemptionController {

//     private final KeyExemptionService keyExemptionService;

//     public KeyExemptionController(KeyExemptionService keyExemptionService) {
//         this.keyExemptionService = keyExemptionService;
//     }

//     @GetMapping
//     public List<KeyExemption> getAllKeyExemptions() {
//         return keyExemptionService.getAllExemptions();
//     }
// }

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

    // Get all key exemptions
    @GetMapping
    public List<KeyExemption> getAllKeyExemptions() {
        return keyExemptionService.getAllExemptions();
    }

    // Create a new key exemption
    @PostMapping
    public KeyExemption createKeyExemption(@RequestBody KeyExemption keyExemption) {
        return keyExemptionService.save(keyExemption);
    }
}
