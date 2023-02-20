package com.se2212.web_service_for_jokes.controller;

import com.se2212.web_service_for_jokes.dto.RatingRequest;
import com.se2212.web_service_for_jokes.entity.Joke;
import com.se2212.web_service_for_jokes.entity.NewJoke;
import com.se2212.web_service_for_jokes.repository.UserRepository;
import com.se2212.web_service_for_jokes.security.JwtService;
import com.se2212.web_service_for_jokes.service.JokesService;
import com.se2212.web_service_for_jokes.service.NewJokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@RequestMapping("/api")
@RestController
public class JokesRestController {

    private final JokesService jokesService;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final NewJokeService newJokeService;

    @Autowired
    public JokesRestController(JokesService jokesService, JwtService jwtService, UserRepository userRepository, NewJokeService newJokeService) {
        this.jokesService = jokesService;
        this.jwtService = jwtService;
        this.userRepository = userRepository;
        this.newJokeService = newJokeService;
    }

    @GetMapping("/jokes")
    public List<Joke> showAllJokes(){
        List<Joke> jokes = jokesService.getAllJokes();
        return jokes;
    }
    @GetMapping("/jokes/sorted")
    public List<Joke> showAllJokesDesc(){
        List<Joke> jokes = jokesService.getAllJokes();
        Collections.sort(jokes);
        return jokes;
    }
    @RequestMapping("/jokes")
    public List<Joke> showJokesByCategory(@RequestParam(value="category") String category){
        List<Joke> jokes = jokesService.getJokesByCategory(category);
        return jokes;
    }

    @GetMapping("/jokes/getlucky")
    public Joke getRandomJoke(){
        int maximum = showAllJokes().size();
        int rng = (int)(Math.random()*maximum);
        return showAllJokes().get(rng);
    }

    @GetMapping("/jokes/getlucky/{howmuch}")
    public List<Joke> getRandomJoke(@PathVariable int howmuch){
        List<Joke> fullist = showAllJokes();
        int maximum = fullist.size();
        HashSet<Integer> idset = new HashSet<>();
        List<Joke> returnlist = new ArrayList<>();
        if (howmuch>maximum){
            howmuch=maximum;
        }
        while (howmuch>0) {
            int rng = (int)(Math.random() * maximum);
            if (!idset.contains(rng) && maximum>returnlist.size()){
                howmuch--;
                returnlist.add(fullist.get(rng));
                idset.add(rng);
            }
        }
        return returnlist;
    }

    @GetMapping("/jokes/{id}")
    public Joke showJoke(@PathVariable int id){
        Joke joke = jokesService.getJokeById(id);
        return joke;
    }

    @PostMapping("/jokes/{id}")
    public void rateJoke(@PathVariable int id,
                         @RequestBody RatingRequest vote)
    {
        Joke joke = jokesService.getJokeById(id);
        joke.updateRating(vote.getRating());
        jokesService.saveJoke(joke);
    }

    @PostMapping("/jokes")
    public void saveJoke(@RequestHeader(value = "Authorization") String token,
                         @RequestBody NewJoke joke){
        token = token.substring(7);
        String author_name = jwtService.extractUsername(token);
        joke.setAuthor(userRepository.findByUsername(author_name).orElseThrow());
        newJokeService.saveJoke(joke);
    }

    @PutMapping("/admin/jokes")
    public Joke updateJoke(@RequestBody Joke updatedjoke){
        jokesService.saveJoke(updatedjoke);
        return updatedjoke;
    }
    @DeleteMapping("/admin/jokes/{id}")
    public List<Joke> deleteJoke(@PathVariable int id){
        jokesService.deleteJoke(id);
        return showAllJokes();
    }
}
