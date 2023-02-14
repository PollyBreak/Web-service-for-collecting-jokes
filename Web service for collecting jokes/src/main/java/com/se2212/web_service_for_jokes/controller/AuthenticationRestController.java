package com.se2212.web_service_for_jokes.controller;

import com.se2212.web_service_for_jokes.dto.AuthenticationRequestDto;
import com.se2212.web_service_for_jokes.entity.User;
import com.se2212.web_service_for_jokes.security.JwtTokenProvider;
import com.se2212.web_service_for_jokes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationRestController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;
    private final UserService userService;

    @Autowired
    public AuthenticationRestController(AuthenticationManager authenticationManager, JwtTokenProvider tokenProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationRequestDto requestDto){
        try{
            String username = requestDto.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDto.getPassword()));
            User user = userService.findByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException("User with such username wasn't found");
            }
            String token = tokenProvider.createToken(username, user.getRoles()); // can be updated (change param list)
            Map<Object, Object> responseMap = new HashMap<>(); // may be change first obj -> string
            responseMap.put("username", user);
            responseMap.put("token", token);
            return ResponseEntity.ok(responseMap);
        }
        catch (AuthenticationException authenticationException) {
            throw new BadCredentialsException("Incorrect username or password");
        }
    }
}
