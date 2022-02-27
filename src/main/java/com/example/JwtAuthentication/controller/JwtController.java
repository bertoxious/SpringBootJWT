package com.example.JwtAuthentication.controller;

import com.example.JwtAuthentication.entities.JwtRequest;
import com.example.JwtAuthentication.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtController {

    @Autowired
    private JwtService jwtService;

    @PostMapping({"/authenticate","/AUTHENTICATE"})
    public void createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception{
        jwtService.createJwtToken(jwtRequest);
    }


}
