package com.example.JwtAuthentication.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {
    private static final String SECRET_KEY = "GODS";
    private static final int TOKEN_VALIDITY = 3600 * 5;
    public String getUsernameFromToken(String jwtToken){
        return getClaimFromToken(jwtToken, Claims::getSubject);

    }

    private <T> T getClaimFromToken(String jwtToken, Function<Claims, T> claimResolver){
        final Claims claims = getAllClaimsFromToken(jwtToken);
        return claimResolver.apply(claims);

    }

    private Claims getAllClaimsFromToken(String jwtToken){
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(jwtToken).getBody();
    }

    public boolean validateToken(String token, UserDetails userDetails){
        String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String jwtToken){
        Date expirationDate = getExpirationDateFromToken(jwtToken);
        return expirationDate.before(new Date());
    }

    private Date getExpirationDateFromToken(String jwtToken){
        return getClaimFromToken(jwtToken, Claims::getExpiration);
    }

    public String generateJwtToken(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder().
                setClaims(claims).
                setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY)
                .compact();

    }

}
