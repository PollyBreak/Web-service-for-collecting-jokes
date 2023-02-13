package com.se2212.web_service_for_jokes.repository;

import com.se2212.web_service_for_jokes.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
}
