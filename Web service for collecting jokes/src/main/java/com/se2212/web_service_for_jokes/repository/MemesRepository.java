package com.se2212.web_service_for_jokes.repository;

import com.se2212.web_service_for_jokes.entity.Meme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemesRepository extends JpaRepository<Meme, Integer> {
}
