package com.se2212.web_service_for_jokes.repository;

import com.se2212.web_service_for_jokes.entity.Joke;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JokesRepository extends JpaRepository<Joke,Integer> {
    List<Joke> findAllByJokeCategoryName(String category);

    List<Joke> findAllByJokeCategoryId(int id);
}
