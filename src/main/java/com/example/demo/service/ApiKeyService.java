package com.example.demo.service;

import com.example.demo.entity.ApiKey;
import java.util.List;

public interface ApiKeyService {

    ApiKey createKey();

    List<ApiKey> getAll();

    void deactivate(Long id);
}
