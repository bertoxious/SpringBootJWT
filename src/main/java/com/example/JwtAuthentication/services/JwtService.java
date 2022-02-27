package com.example.JwtAuthentication.services;

import com.example.JwtAuthentication.entities.JwtRequest;
import com.example.JwtAuthentication.entities.JwtResponse;
import com.example.JwtAuthentication.entities.User;
import com.example.JwtAuthentication.repositories.UserRepo;
import com.example.JwtAuthentication.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JwtService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception{
        String username = jwtRequest.getUsername();
        String userPassword = jwtRequest.getUserPassword();
        authenticate(username, userPassword);
        final UserDetails userDetails = loadUserByUsername(username);
        String newGeneratedToken =  jwtUtil.generateJwtToken(userDetails);
        User user = userRepo.findById(username).get();
        return new JwtResponse(user, newGeneratedToken);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findById(username).get();
        if (user != null){
            return new org.springframework.security.core.userdetails.User(
                    user.getUserName(),
                    user.getUserPassword(),
                    getAuthorities(user)
            );
        }
        else {
            throw new UsernameNotFoundException("Username is not Valid");
        }
    }

    private Set getAuthorities(User user){
        Set authorities = new HashSet();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        });
        return authorities;
    }

    private void authenticate(String username, String userPassword) throws Exception{
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, userPassword));
        }
        catch(DisabledException e){
            throw new Exception("User is disabled");
        }
        catch (BadCredentialsException e){
            throw new Exception("Bad Credentials from user");
        }

    }
}
