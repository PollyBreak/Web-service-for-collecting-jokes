package com.se2212.web_service_for_jokes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "new_jokes")
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

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
}
