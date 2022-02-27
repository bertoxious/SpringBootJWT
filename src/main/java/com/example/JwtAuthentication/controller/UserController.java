package com.example.JwtAuthentication.controller;

import com.example.JwtAuthentication.dto.AssignRole;
import com.example.JwtAuthentication.entities.User;
import com.example.JwtAuthentication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @Autowired
    private UserService userService;
    @PostMapping(value = {"/create-user","/register"})
    public User createUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/user-content")
    @PreAuthorize("hasRole('USER')")
    public String content(){
        return "This is only accessible to user";
    }

    @GetMapping("/admin-content")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminContent(){
        return "This is only accessible to admin";
    }

    @PostMapping("/assign-role")
    public User assignRole(@RequestBody AssignRole assignRole) throws Exception{
        return userService.assignRole(assignRole.getUsername(), assignRole.getRole());
    }
}
