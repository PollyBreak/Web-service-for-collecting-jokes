package com.se2212.web_service_for_jokes.service;

import com.se2212.web_service_for_jokes.repository.RoleRepository;
import com.se2212.web_service_for_jokes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository/*, BCryptPasswordEncoder passwordEncoder*/){
        this.userRepository=userRepository;
        this.roleRepository=roleRepository;
        this.passwordEncoder= new BCryptPasswordEncoder();
    }

}
