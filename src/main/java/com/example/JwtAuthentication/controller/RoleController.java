package com.example.JwtAuthentication.controller;

import com.example.JwtAuthentication.entities.Role;
import com.example.JwtAuthentication.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping({"/add-role","addRole"})
    public Role addRole(@RequestBody Role role){
        return roleService.addRole(role);
    }

}
