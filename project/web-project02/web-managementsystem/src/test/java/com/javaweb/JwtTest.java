package com.javaweb;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class JwtTest {

    /**
     * Générer un jeton JWT
     * Generate a JWT token
     */
    @Test
    public void testGenerateJwt() {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("userId", "1");
        dataMap.put("username", "admin");
        //javaweb->base64 encode --> "amF2YXdlYg=="
        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256,"amF2YXdlYg==")
                .addClaims(dataMap)//Ajouter des informations personnalisées
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 ))
                .compact();//Generate a JWT token
        System.out.println(jwt);

    }

    /**
     * Parse Jwt token
     */
    @Test
    public void testParseJwt() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiIxIiwidXNlcm5hbWUiOiJhZG1pbiIsImV4cCI6MTc0MTcxOTg0Nn0.UkXj97kj4uHJXBy5EUKftkHUl6tjZOtkIOnxBJ5sM-Q";
        Claims claims = Jwts.parser().setSigningKey("amF2YXdlYg==")//Spécifier une clé secrète
                .parseClaimsJws(token)//parse token
                .getBody();//get the info personal
        System.out.println(claims);
    }
}
