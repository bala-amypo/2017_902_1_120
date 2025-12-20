package com.example.demo.service;

import com.example.demo.entity.QuotaPlan;
import java.util.List;

public interface QuotaPlanService {

    QuotaPlan create(QuotaPlan plan);

    List<QuotaPlan> getAll();
}
