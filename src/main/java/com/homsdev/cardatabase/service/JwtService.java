package com.homsdev.cardatabase.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    static final long EXPIRATION_TIME = 86400000;//1 day in ms

    static final String PREFIX = "Bearer";

    /**
     * Generate Secret key. Only for demo purpose
     * Key must be read from the application configuration
     */
    static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    /**
     * Generate signed JWT token
     * @param username
     * @return
     */
    public String getToken(String username) {
        String token = Jwts.builder()
                .setSubject(username)
                .claim("username",username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
        return token;
    }

    /**
     * Get a token from request Authorization Header & verify token and get username
     *
     * @param request
     * @return
     */
    public String getAuthUser(HttpServletRequest request) {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (token != null) {
            String user = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token.replace(PREFIX, ""))
                    .getBody()
                    .getSubject();
            if (user != null) {
                return user;
            }
        }
        return null;
    }
}
