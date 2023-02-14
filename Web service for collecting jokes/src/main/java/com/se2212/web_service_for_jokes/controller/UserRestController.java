package com.se2212.web_service_for_jokes.controller;

import com.se2212.web_service_for_jokes.entity.User;
import com.se2212.web_service_for_jokes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRestController {
    private final UserService userService;
    public UserRestController(UserService userService) {
        this.userService=userService;
    }
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User findUserById(@PathVariable int id){
        return userService.findById(id);
    }
}
