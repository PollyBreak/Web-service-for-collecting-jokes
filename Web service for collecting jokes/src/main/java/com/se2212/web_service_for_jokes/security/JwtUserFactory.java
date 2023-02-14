package com.se2212.web_service_for_jokes.security;

import com.se2212.web_service_for_jokes.entity.Role;
import com.se2212.web_service_for_jokes.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

/*public class JwtUserFactory {
    public JwtUserFactory(){}
    public static JwtUser create(User user){
        return new JwtUser(user.getId(),
                user.getUsername(),
                user.getFirstName(),
                user.getPassword(),
                user.getEmail(),
                user.getStatus(),
                mapToGrantedAuthorities(user.getRoles()));
    }
    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}*/
