package com.example.JwtAuthentication.services;

import com.example.JwtAuthentication.entities.Role;
import com.example.JwtAuthentication.repositories.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;

    public Role addRole(Role role){
        return roleRepo.save(role);
    }
}
