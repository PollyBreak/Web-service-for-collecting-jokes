package com.se2212.web_service_for_jokes.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "category_jokes")
public class JokeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int id;

    @NotBlank(message = "Name cannot be blank")
    @Column(name = "name")
    private String name;

}
