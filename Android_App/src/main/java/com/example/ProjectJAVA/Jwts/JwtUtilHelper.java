package com.example.ProjectJAVA.Jwts;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
public class JwtUtilHelper {

    @Value("${jwt.privateKey}")
    private String privateKey;

    public String GenerateToken(String Data){
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));
        return Jwts.builder().subject(Data).signWith(key).compact();
    }

    private Claims extractAllClaims(String token){
        return Jwts.parser()
                .verifyWith(getKey()) // Dynamically supply the key
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
    public boolean verifyToken(String Token){

        System.out.println("token received " + Token);

        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));

        System.out.println("key" + key);

        try {
            extractAllClaims(Token).getSubject();
            System.out.println("Success");
            return true;

        }catch (Exception e){
            System.out.println("failed" + e.getMessage());
            return false;
        }
    }

    private SecretKey getKey(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));
    }
}
