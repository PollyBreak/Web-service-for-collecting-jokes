package com.se2212.web_service_for_jokes.controller;

import com.se2212.web_service_for_jokes.dto.AuthenticationRequestDto;
import com.se2212.web_service_for_jokes.entity.User;
import com.se2212.web_service_for_jokes.security.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationRestController {
    private final AuthentificationService service;
    @PostMapping("/register")
    public ResponseEntity<AuthentificationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthentificationResponse> authenticate(
            @RequestBody AuthentificationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}
