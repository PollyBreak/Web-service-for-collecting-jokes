package com.se2212.web_service_for_jokes.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int id;
    @Column(name="role")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "roles")
    private List<User> users;

}
