package com.example.JwtAuthentication.entities;

import lombok.Data;

@Data
public class JwtRequest {

    private String username;
    private String userPassword;

}
