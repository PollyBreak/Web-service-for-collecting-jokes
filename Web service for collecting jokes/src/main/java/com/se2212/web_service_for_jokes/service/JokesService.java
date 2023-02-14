package com.se2212.web_service_for_jokes.service;

import com.se2212.web_service_for_jokes.entity.Joke;
import com.se2212.web_service_for_jokes.entity.JokeCategory;
import com.se2212.web_service_for_jokes.repository.JokesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JokesService {
    private final JokesRepository jokesRepository;
    public JokesService(JokesRepository jokesRepository) {
        this.jokesRepository = jokesRepository;
    }

    public List<Joke> getAllJokes(){
        return jokesRepository.findAll();
    }

    public Joke getJokeById(int id) {
        Optional<Joke> optional = jokesRepository.findById(id); //as findById returns Optional
        return optional.orElse(null);
    }
    public void saveJoke(Joke newjoke){
        jokesRepository.save(newjoke);
    }
    public void deleteJoke(int id){
        jokesRepository.deleteById(id);
    }
}
