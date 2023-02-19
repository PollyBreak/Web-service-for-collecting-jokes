package com.se2212.web_service_for_jokes.controller;

import com.se2212.web_service_for_jokes.entity.Meme;
import com.se2212.web_service_for_jokes.service.MemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MemesRestController {
    private MemeService memeService;

    @Autowired
    public MemesRestController(MemeService memeService) {
        this.memeService = memeService;
    }

    @GetMapping (value ="/meme")
    public List<Meme> showAllMemes(){
        List<Meme> memes=memeService.getAllMemes();
        return memes;
    }
    @GetMapping(value = "/meme/{id}")
    public Meme showMeme(@PathVariable int id){
        Meme meme=memeService.getMemeById(id);
        return meme;
    }
    @PostMapping("/meme")
    public void saveMeme(@RequestBody Meme meme){
        memeService.saveMeme(meme);
    }
    @PutMapping("/meme")
    public Meme updateMeme(@RequestBody Meme updatememe){
        memeService.saveMeme(updatememe);
        return updatememe;
    }
    @DeleteMapping("/meme/{id}")
    public List<Meme> deleteMeme(@PathVariable int id){
        memeService.deleteMeme(id);
        return showAllMemes();
    }
}
