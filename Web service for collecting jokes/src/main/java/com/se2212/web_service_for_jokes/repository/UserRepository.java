package com.se2212.web_service_for_jokes.repository;

import com.se2212.web_service_for_jokes.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);
}
