package com.se2212.web_service_for_jokes.service;

import com.se2212.web_service_for_jokes.entity.User;
import com.se2212.web_service_for_jokes.repository.RoleRepository;
import com.se2212.web_service_for_jokes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.roleRepository=roleRepository;
        this.passwordEncoder= passwordEncoder;
    }
    public List<User> getAllUsers(){return userRepository.findAll();}
    public User findById(int id){
        Optional<User> optional = userRepository.findById(id);
        return optional.orElse(null);
    }
    //may be obsolete
    public User findByUsername(String username){
        User result = userRepository.findByUsername(username);
        return result;
    }
    public void deleteUser(int id){
        userRepository.deleteById(id);
    }
}*/
