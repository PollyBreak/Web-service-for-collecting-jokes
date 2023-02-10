package com.se2212.web_service_for_jokes.entity;

<<<<<<< Updated upstream
public class Meme {
    
=======

import jakarta.persistence.Entity;
import jakarta.persistence.*;
@Entity
@Table(name="memes")
public class Meme {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="memes_id")
    private int id;

    @Column(name="text")
    private String text;

    @ManyToOne
    @JoinColumn(name="category_id")
    private JokeCategory jokeCategory;

    public Meme(String name, JokeCategory jokeCategory){
        this.text=name;
        this.jokeCategory=jokeCategory;
    }
    public Meme(){
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setJokeCategory(JokeCategory jokeCategory) {
        this.jokeCategory = jokeCategory;
    }

    public JokeCategory getJokeCategory() {
        return jokeCategory;
    }

    @Override
    public String toString() {
        return "Meme:" + text + '\'';
    }
>>>>>>> Stashed changes
}
