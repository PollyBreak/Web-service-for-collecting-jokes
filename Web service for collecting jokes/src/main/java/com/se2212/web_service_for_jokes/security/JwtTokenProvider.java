package com.se2212.web_service_for_jokes.security;

import com.se2212.web_service_for_jokes.entity.Role;
import io.jsonwebtoken.*;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

/*@Component
public class JwtTokenProvider {

    @Value("${jwt.token.secret}")
    private String secret;

    @Value("${jwt.token.expired}")
    private long validity;

    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @PostConstruct
    private void init(){
        secret = Base64.getEncoder().encodeToString(secret.getBytes());
    }

    public String createToken(String username, List<Role> roles){
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("roles", getRoleNames(roles));
        Date createDate = new Date();
        Date finishTime = new Date(createDate.getTime() + validity);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(createDate)
                .setExpiration(finishTime)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    private List<String> getRoleNames(List<Role> userRoles){
        List<String> result = new ArrayList<>();
        userRoles.forEach(role -> result.add(role.getName()));
        return result;
    }


    public String getUsername(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }
    public Authentication getAuthentication(String token){
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(getUsername(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }
    public String resolveToken(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer_")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }

    public boolean validateToken(String token){
        try {
            Jws<Claims> jwsClaims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            if (jwsClaims.getBody().getExpiration().before(new Date())) {
                return false;
            }
            return true;
        }
        catch (JwtException | IllegalArgumentException e) {
            throw new JwtAuthenticationException("Jwt token is invalid");
        }
    }

}*/
