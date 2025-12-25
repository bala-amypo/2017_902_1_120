// package com.example.demo.controller;

// import com.example.demo.entity.QuotaPlan;
// import com.example.demo.service.QuotaPlanService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/quota-plans")
// public class QuotaPlanController {

//     private final QuotaPlanService quotaPlanService;

//     public QuotaPlanController(QuotaPlanService quotaPlanService) {
//         this.quotaPlanService = quotaPlanService;
//     }

//     @PostMapping
//     public QuotaPlan createQuotaPlan(@RequestBody QuotaPlan plan) {
//         return quotaPlanService.create(plan);
//     }

//     @GetMapping
//     public List<QuotaPlan> getAllQuotaPlans() {
//         return quotaPlanService.getAll();
//     }
// }

package com.example.demo.controller;

import com.example.demo.entity.QuotaPlan;
import com.example.demo.service.QuotaPlanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quota-plans")
public class QuotaPlanController {

    private final QuotaPlanService quotaPlanService;

    public QuotaPlanController(QuotaPlanService quotaPlanService) {
        this.quotaPlanService = quotaPlanService;
    }

    // Create a new quota plan
    @PostMapping
    public QuotaPlan createQuotaPlan(@RequestBody QuotaPlan plan) {
        return quotaPlanService.create(plan);
    }

    // Get all quota plans
    @GetMapping
    public List<QuotaPlan> getAllQuotaPlans() {
        return quotaPlanService.getAll();
    }
}
