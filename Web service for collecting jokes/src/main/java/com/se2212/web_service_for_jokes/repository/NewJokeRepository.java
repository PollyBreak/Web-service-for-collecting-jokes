package com.se2212.web_service_for_jokes.repository;

import com.se2212.web_service_for_jokes.entity.NewJoke;
import com.se2212.web_service_for_jokes.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NewJokeRepository extends JpaRepository<NewJoke,Integer> {
}
