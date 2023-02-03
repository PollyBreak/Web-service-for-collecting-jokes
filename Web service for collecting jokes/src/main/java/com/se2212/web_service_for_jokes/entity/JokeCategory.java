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

    public JokeCategory(String name) {
        this.name = name;
    }

    public JokeCategory() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Категория: " + name + '\'';
    }
}
