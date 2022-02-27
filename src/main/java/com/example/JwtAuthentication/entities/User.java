package com.example.JwtAuthentication.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class User {
    @Id
    private String userName;
    private String userFirstName;
    private String userLastName;
    private String userPassword;
    private String confirmPassword;


    @ManyToMany(fetch= FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE",
    joinColumns = @JoinColumn(name="USER_ID"),
    inverseJoinColumns = @JoinColumn(name="ROLE_ID"))
    Set<Role> roles = new HashSet<>();

}
