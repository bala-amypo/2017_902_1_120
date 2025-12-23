// package com.example.demo.controller;

// import com.example.demo.entity.RateLimitEnforcement;
// import com.example.demo.service.RateLimitEnforcementService;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/enforcements")
// public class RateLimitEnforcementController {

//     private final RateLimitEnforcementService rateLimitEnforcementService;

//     public RateLimitEnforcementController(RateLimitEnforcementService rateLimitEnforcementService) {
//         this.rateLimitEnforcementService = rateLimitEnforcementService;
//     }

//     @PostMapping
//     public RateLimitEnforcement createEnforcement(
//             @RequestBody RateLimitEnforcement enforcement) {
//         return rateLimitEnforcementService.create(enforcement);
//     }
// }

// package com.example.demo.controller;

// import com.example.demo.entity.RateLimitEnforcement;
// import com.example.demo.service.RateLimitEnforcementService;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/rate-limit")
// public class RateLimitEnforcementController {

//     private final RateLimitEnforcementService service;

//     public RateLimitEnforcementController(RateLimitEnforcementService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public RateLimitEnforcement create(@RequestBody RateLimitEnforcement enforcement) {
//         return service.save(enforcement); // ✅ save(), not create()
//     }
// }

package com.example.demo.controller;

import com.example.demo.entity.RateLimitEnforcement;
import com.example.demo.service.RateLimitEnforcementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rate-limit")
public class RateLimitEnforcementController {

    private final RateLimitEnforcementService rateLimitEnforcementService;

    public RateLimitEnforcementController(RateLimitEnforcementService rateLimitEnforcementService) {
        this.rateLimitEnforcementService = rateLimitEnforcementService;
    }

    @PostMapping
    public ResponseEntity<RateLimitEnforcement> create(
            @RequestBody RateLimitEnforcement enforcement) {

        RateLimitEnforcement saved =
                rateLimitEnforcementService.create(enforcement);

        return ResponseEntity.ok(saved);
    }
}



