// package com.example.demo.service.impl;

// import com.example.demo.entity.QuotaPlan;
// import com.example.demo.repository.QuotaPlanRepository;
// import com.example.demo.service.QuotaPlanService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class QuotaPlanServiceImpl implements QuotaPlanService {

//     private final QuotaPlanRepository quotaPlanRepository;

//     public QuotaPlanServiceImpl(QuotaPlanRepository quotaPlanRepository) {
//         this.quotaPlanRepository = quotaPlanRepository;
//     }

//     @Override
//     public QuotaPlan create(QuotaPlan plan) {
//         return quotaPlanRepository.save(plan);
//     }

//     @Override
//     public List<QuotaPlan> getAll() {
//         return quotaPlanRepository.findAll();
//     }
// }

package com.example.demo.service.impl;

import com.example.demo.entity.QuotaPlan;
import com.example.demo.repository.QuotaPlanRepository;
import com.example.demo.service.QuotaPlanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuotaPlanServiceImpl implements QuotaPlanService {

    private final QuotaPlanRepository quotaPlanRepository;

    public QuotaPlanServiceImpl(QuotaPlanRepository quotaPlanRepository) {
        this.quotaPlanRepository = quotaPlanRepository;
    }

    @Override
    public QuotaPlan create(QuotaPlan plan) {
        return quotaPlanRepository.save(plan);
    }

    @Override
    public List<QuotaPlan> getAll() {
        return quotaPlanRepository.findAll();
    }
}
