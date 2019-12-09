package com.ilisi.roommatebackend.core.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    @Value("${authentication.jwt.secret}")
    private String secret;

    @Value("${authentication.jwt.expiration}")
    private Long expiration;

    public String generateToken(UserDetails jwtUser) {
        Map<String, Object> claims = new HashMap<String, Object>();

        claims.put("username", jwtUser.getUsername());

        claims.put("creationDate", new Date());

        return generateToken(claims);
    }

    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(claims.get("username").toString())
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public Date getExpirationDateFromToken(String token) {
        Date expiration;

        try {
            final Claims claims = getClaimsFromToken(token);

            expiration = claims.getExpiration();
        } catch (Exception e) {
            expiration = null;
        }

        return expiration;
    }

    public Integer getUserIdFromToken(String token) {
        if (token == null) {
            return null;
        }

        Integer id;

        try {
            final Claims claims = getClaimsFromToken(token);

            id = (Integer) claims.get("id");
        } catch (Exception e) {
            id = null;
        }

        return id;
    }

    public String getUsernameFromToken(String token) {
        String username;

        try {
            final Claims claims = getClaimsFromToken(token);
            username = claims.get("username").toString(); // claims.getSubject();
        } catch (Exception e) {
            username = null;
        }

        return username;
    }

    private Boolean isTokenExpired(String token) {

        return getExpirationDateFromToken(token).before(new Date());
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        AppUserDetails user = (AppUserDetails) userDetails;
        final String username = getUsernameFromToken(token);

        return (username.equals(user.getUsername()) && !isTokenExpired(token) );
    }

    private Claims getClaimsFromToken(String token) {
        Claims claims;

        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }

        return claims;
    }
}
