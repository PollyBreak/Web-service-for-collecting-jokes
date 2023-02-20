package com.se2212.web_service_for_jokes.dto;

import com.se2212.web_service_for_jokes.entity.JokeCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewJokeDto {
    private int id;
    private String text;
    private JokeCategory jokeCategory;
    private UserDto author;
}
