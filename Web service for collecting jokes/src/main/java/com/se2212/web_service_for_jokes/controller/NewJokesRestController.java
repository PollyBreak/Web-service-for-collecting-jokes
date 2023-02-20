package com.se2212.web_service_for_jokes.controller;

import com.se2212.web_service_for_jokes.dto.NewJokeDto;
import com.se2212.web_service_for_jokes.dto.UserDto;
import com.se2212.web_service_for_jokes.entity.Joke;
import com.se2212.web_service_for_jokes.entity.NewJoke;
import com.se2212.web_service_for_jokes.entity.User;
import com.se2212.web_service_for_jokes.service.JokesService;
import com.se2212.web_service_for_jokes.service.NewJokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NewJokesRestController {

    private final NewJokeService newJokeService;
    private final JokesService jokesService;

    @Autowired
    public NewJokesRestController(NewJokeService newJokeService, JokesService jokesService) {
        this.newJokeService = newJokeService;
        this.jokesService = jokesService;
    }

    @GetMapping("/admin/newjokes")
    public List<NewJokeDto> showNewJokes(){
        List<NewJoke> jokes = newJokeService.getAllJokes();
        List<NewJokeDto> dtojokes = new ArrayList<>();
        for(NewJoke joke:jokes){
            User author = joke.getAuthor();
            dtojokes.add(new NewJokeDto(joke.getId(), joke.getText(), joke.getJokeCategory(),new UserDto(author.getId(),author.getUsername())));
        }
        return dtojokes;
    }

    @GetMapping("/admin/newjokes/{id}")
    public NewJoke showNewJoke(@PathVariable int id){
        NewJoke joke = newJokeService.getJokeById(id);
        return joke;
    }

    @GetMapping("/admin/newjokes/{id}/accept")
    public void acceptNewJoke(@PathVariable int id){
        NewJoke joke = newJokeService.getJokeById(id);
        Joke newjoke = new Joke(joke.getText(), joke.getJokeCategory());
        jokesService.saveJoke(newjoke);
        deleteNewJoke(id);
    }

    @PutMapping("/admin/newjokes")
    public NewJoke updateNewJoke(@RequestBody NewJoke updatedjoke){
        newJokeService.saveJoke(updatedjoke);
        return updatedjoke;
    }

    @DeleteMapping("/admin/newjokes/{id}")
    public void deleteNewJoke(@PathVariable int id){
        newJokeService.deleteJoke(id);
    }
}
