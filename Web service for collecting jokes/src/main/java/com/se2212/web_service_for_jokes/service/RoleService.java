package com.se2212.web_service_for_jokes.service;

import com.se2212.web_service_for_jokes.entity.Joke;
import com.se2212.web_service_for_jokes.entity.Role;
import com.se2212.web_service_for_jokes.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }

    public Role getRoleById(int id) {
        Optional<Role> optional = roleRepository.findById(id); //as findById returns Optional
        return optional.orElse(null);
    }

    public void saveRole(Role newRole){
        roleRepository.save(newRole);
    }

    public void deleteRole(int id){
        roleRepository.deleteById(id);
    }
}
