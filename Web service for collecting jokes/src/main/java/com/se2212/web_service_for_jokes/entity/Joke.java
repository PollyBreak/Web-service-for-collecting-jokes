package com.se2212.web_service_for_jokes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jokes")
public class Joke {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "text")
    private String text;

    @Column(name = "rating")
    private int rating = 0;

    @ManyToOne
    @JoinColumn(name ="category_id")
    private JokeCategory jokeCategory;

    public Joke(String text, JokeCategory jokeCategory) {
        this.text = text;
        this.jokeCategory = jokeCategory;
    }

    public void updateRating(boolean rating) {
        if (rating) {
            this.rating++;
        } else {
            this.rating--;
        }
    }
}

