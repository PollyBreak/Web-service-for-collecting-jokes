package com.se2212.web_service_for_jokes.security;

import com.se2212.web_service_for_jokes.dto.AuthenticationRequest;
import com.se2212.web_service_for_jokes.dto.AuthenticationResponse;
import com.se2212.web_service_for_jokes.dto.RegisterRequest;
import com.se2212.web_service_for_jokes.entity.User;
import com.se2212.web_service_for_jokes.entity.Role;
import com.se2212.web_service_for_jokes.repository.RoleRepository;
import com.se2212.web_service_for_jokes.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthentificationService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.getById(1));
        var user = User.builder()
                .username(request.getUsername())
                .firstName(request.getFirstName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(roles)
                .status(true)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
