package com.se2212.web_service_for_jokes.service;

import com.se2212.web_service_for_jokes.entity.NewJoke;
import com.se2212.web_service_for_jokes.repository.JokesRepository;
import com.se2212.web_service_for_jokes.repository.NewJokeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewJokeService {
    private final NewJokeRepository newJokeRepository;
    public NewJokeService(NewJokeRepository jokesRepository) {
        this.newJokeRepository = jokesRepository;
    }
    public List<NewJoke> getAllJokes(){
        return newJokeRepository.findAll();
    }
    public NewJoke getJokeById(int id) {
        Optional<NewJoke> optional = newJokeRepository.findById(id); //as findById returns Optional
        return optional.orElse(null);
    }
    public void saveJoke(NewJoke newjoke){
        newJokeRepository.save(newjoke);
    }
    public void deleteJoke(int id){
        newJokeRepository.deleteById(id);
    }
}
