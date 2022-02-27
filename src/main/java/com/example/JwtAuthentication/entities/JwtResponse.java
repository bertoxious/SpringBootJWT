package com.example.JwtAuthentication.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {

    private User user;
    private String jwtToken;

}
