package com.se2212.web_service_for_jokes.controller;

import com.se2212.web_service_for_jokes.entity.Joke;
import com.se2212.web_service_for_jokes.service.JokesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JokesRestController {
    @Autowired
    private JokesService jokesService;
    @GetMapping("/jokes")
    public List<Joke> showAllJokes(){
        List<Joke> jokes = jokesService.getAllJokes();
        return jokes;
    }
    @GetMapping("/jokes/{id}")
    public Joke showJoke(@PathVariable int id){
        Joke joke = jokesService.getJokeById(id);
        return joke;
    }
    @PostMapping("/jokes")
    public void saveJoke(@RequestBody Joke joke){
        jokesService.saveJoke(joke);
    }
    @PutMapping("/jokes")
    public Joke updateJoke(@RequestBody Joke updatedjoke){
        jokesService.saveJoke(updatedjoke);
        return updatedjoke;
    }
    @DeleteMapping("/jokes/{id}")
    public List<Joke> deleteJoke(@PathVariable int id){
        jokesService.deleteJoke(id);
        return showAllJokes();
    }
}
