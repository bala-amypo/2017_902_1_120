package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.AuthResponseDto;
import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.entity.UserAccount;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserAccountRepository userAccountRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(UserAccountRepository userAccountRepository,
                          PasswordEncoder passwordEncoder,
                          AuthenticationManager authenticationManager,
                          JwtUtil jwtUtil) {
        this.userAccountRepository = userAccountRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @Override
public AuthResponseDto login(AuthRequestDto request) {

    authenticationManager.authenticate(
            new org.springframework.security.authentication.UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getPassword()
            )
    );

    UserAccount user = userAccountRepository
            .findByEmail(request.getEmail())
            .orElseThrow(() -> new BadRequestException("Invalid credentials"));

    Map<String, Object> claims = new HashMap<>();
    claims.put("role", user.getRole());

    String token = jwtUtil.generateToken(claims, user.getEmail());

    AuthResponseDto response = new AuthResponseDto();
    response.setToken(token);
    response.setUserId(user.getId());
    response.setEmail(user.getEmail());
    response.setRole(user.getRole());

    return response;
}

@Override
public AuthResponseDto login(AuthRequestDto request) {

    authenticationManager.authenticate(
            new org.springframework.security.authentication.UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getPassword()
            )
    );

    UserAccount user = userAccountRepository
            .findByEmail(request.getEmail())
            .orElseThrow(() -> new BadRequestException("Invalid credentials"));

    Map<String, Object> claims = new HashMap<>();
    claims.put("role", user.getRole());

    String token = jwtUtil.generateToken(claims, user.getEmail());

    AuthResponseDto response = new AuthResponseDto();
    response.setToken(token);
    response.setUserId(user.getId());
    response.setEmail(user.getEmail());
    response.setRole(user.getRole());

    return response;
}

}

