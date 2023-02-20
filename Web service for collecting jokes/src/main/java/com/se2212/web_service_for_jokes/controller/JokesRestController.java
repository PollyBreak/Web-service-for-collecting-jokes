package com.se2212.web_service_for_jokes.controller;

import com.se2212.web_service_for_jokes.dto.RatingRequest;
import com.se2212.web_service_for_jokes.entity.Joke;
import com.se2212.web_service_for_jokes.entity.JokeCategory;
import com.se2212.web_service_for_jokes.entity.NewJoke;
import com.se2212.web_service_for_jokes.service.JokesService;
import com.se2212.web_service_for_jokes.service.NewJokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class JokesRestController {
    @Autowired
    private JokesService jokesService;
    @Autowired
    private NewJokeService newJokeService;
    @GetMapping("/jokes")
    public List<Joke> showAllJokes(){
        List<Joke> jokes = jokesService.getAllJokes();
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
    public void saveJoke(@RequestBody NewJoke joke){
        newJokeService.saveJoke(joke);
    }
    @GetMapping("/admin/newjokes")
    public List<NewJoke> showNewJokes(){
        List<NewJoke> jokes = newJokeService.getAllJokes();
        return jokes;
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
    public NewJoke updateJoke(@RequestBody NewJoke updatedjoke){
        newJokeService.saveJoke(updatedjoke);
        return updatedjoke;
    }
    @DeleteMapping("/admin/newjokes/{id}")
    public void deleteNewJoke(@PathVariable int id){
        newJokeService.deleteJoke(id);
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
