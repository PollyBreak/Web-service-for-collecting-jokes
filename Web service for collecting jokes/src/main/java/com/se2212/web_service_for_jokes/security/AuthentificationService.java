package com.se2212.web_service_for_jokes.security;

import com.se2212.web_service_for_jokes.entity.Role;
import com.se2212.web_service_for_jokes.entity.Status;
import com.se2212.web_service_for_jokes.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthentificationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthentificationResponse register(RegisterRequest request) {
        var user = JwtUser.builder()
                .username(request.getUsername())
                .firstName(request.getFirstname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(List.of(ConstRoles.role_user))
                .status(true)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthentificationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthentificationResponse authenticate(AuthentificationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthentificationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
