package com.se2212.web_service_for_jokes.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "newjokes")
public class NewJoke {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "text")
    private String text;
    @ManyToOne
    @JoinColumn(name ="category_id")
    private JokeCategory jokeCategory;
    public NewJoke() {
    }

    public NewJoke(String text, JokeCategory jokeCategory) {
        this.text = text;
        this.jokeCategory = jokeCategory;
    }
    public void setText(String text) {
        this.text = text;
    }
    public void setJokeCategory(JokeCategory jokeCategory) {
        this.jokeCategory = jokeCategory;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public String getText() {
        return text;
    }
    public JokeCategory getJokeCategory() {
        return jokeCategory;
    }
    @Override
    public String toString() {
        return "Шутка: " + text;
    }
}
