package com.pbl3team2.hotspot.member.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwkUtil {
    public static String createToken(String memberNumber, long expireTimeMs, String key){
        Claims claims = Jwts.claims();
        claims.put("memberNumber", memberNumber);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expireTimeMs))
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }

}
