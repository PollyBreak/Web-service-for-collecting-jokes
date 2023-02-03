package com.se2212.web_service_for_jokes.controller;

import com.se2212.web_service_for_jokes.entity.Joke;
import com.se2212.web_service_for_jokes.entity.JokeCategory;
import com.se2212.web_service_for_jokes.service.JokeCategoryService;
import com.se2212.web_service_for_jokes.service.JokesService;
import jakarta.validation.Valid;
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
    @PostMapping("/jokes/{id}")
    public Joke updateJoke(@PathVariable int id,@RequestBody Joke newjoke){
        Joke crashcaller = jokesService.getJokeById(id); //if trying to update when does not exist it adds, so i just crash the whole thing
        newjoke.setId(id);
        jokesService.saveJoke(newjoke);
        return newjoke;
    }
    @GetMapping("/jokes/{id}/delete")
    public List<Joke> deleteJoke(@PathVariable int id){
        jokesService.deleteJoke(id);
        return showAllJokes();
    }
}
