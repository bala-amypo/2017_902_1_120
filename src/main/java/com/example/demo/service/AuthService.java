package com.example.demo.service;

import com.example.demo.entity.UserAccount;

public interface AuthService {

    UserAccount register(String email, String password);

    UserAccount login(String email, String password);
}
