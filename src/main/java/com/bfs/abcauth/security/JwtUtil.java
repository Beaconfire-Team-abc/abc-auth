package com.bfs.abcauth.security;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;

public class JwtUtil {

    public static String generateToken(String signingKey, HashMap<String, String> payLoad) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        JwtBuilder builder = Jwts.builder();
        for (String key: payLoad.keySet()){
            builder.claim(key, payLoad.get(key));
        }

        builder.setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS256, signingKey);

        return builder.compact();
    }
}
