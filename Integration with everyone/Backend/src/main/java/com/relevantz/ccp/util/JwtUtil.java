package com.relevantz.ccp.util;
import io.jsonwebtoken.Claims;

import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import com.relevantz.ccp.config.AccessDeniedException;
import com.relevantz.ccp.model.User;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    private static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);


    private static final long EXPIRY_DURATION_SECONDS = 360000;//1 hour

    public String generateToken(User user) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRY_DURATION_SECONDS * 1000);

        Claims claims = Jwts.claims().setSubject(user.getUserId().toString());
        claims.put("type", user.getUserType());
        claims.put("email", user.getUserEmailId());

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SECRET_KEY)
                .compact();
    }
   

    // Verify JWT token
    public User verifyToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY)
                    .build()
                    .parseClaimsJws(token);
            String userId = claims.getBody().getSubject();
            String userType = (String) claims.getBody().get("type");
            String userEmail = (String) claims.getBody().get("email");
            User user = new User();
            user.setUserId(Long.parseLong(userId));
            user.setUserType(userType);
            user.setUserEmailId(userEmail);
            return user;
        } catch (Exception e) {
//        	return null;
        	throw new AccessDeniedException("Access Denied");
        }
    }
}