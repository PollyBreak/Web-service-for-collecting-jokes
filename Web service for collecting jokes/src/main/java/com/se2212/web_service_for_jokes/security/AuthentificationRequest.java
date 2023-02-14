package com.se2212.web_service_for_jokes.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthentificationRequest {
    private String username;
    private String password;
}
