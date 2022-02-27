package com.example.JwtAuthentication.services;

import com.example.JwtAuthentication.entities.Role;
import com.example.JwtAuthentication.entities.User;
import com.example.JwtAuthentication.repositories.RoleRepo;
import com.example.JwtAuthentication.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User addUser(User user){
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
        return userRepo.save(user);
    }

    public User assignRole(String username, String roleName) throws Exception{
        try{
            User user = userRepo.findById(username).get();
            Set<Role> roles = new HashSet<>();
            Role role = roleRepo.findById(roleName).get();
            roles.add(role);
            user.setRoles(roles);
            return user;
        }
        catch (Exception e){
            throw new Exception("No Such User");
        }
    }

    public String getEncodedPassword(String password){
        return passwordEncoder.encode(password);
    }
}
