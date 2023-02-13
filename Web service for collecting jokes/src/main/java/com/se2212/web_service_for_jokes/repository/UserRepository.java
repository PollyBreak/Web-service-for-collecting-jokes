package com.se2212.web_service_for_jokes.repository;

import com.se2212.web_service_for_jokes.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByUsername(String username);
}
