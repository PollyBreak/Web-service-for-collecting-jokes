package com.se2212.web_service_for_jokes.repository;

import com.se2212.web_service_for_jokes.entity.User;
import com.se2212.web_service_for_jokes.security.JwtUser;
import io.jsonwebtoken.Jwt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<JwtUser,Integer> {
    public Optional<JwtUser> findByUsername(String username);
}
