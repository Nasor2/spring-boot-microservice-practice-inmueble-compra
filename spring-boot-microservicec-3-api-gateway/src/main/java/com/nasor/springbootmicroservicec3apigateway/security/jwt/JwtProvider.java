package com.nasor.springbootmicroservicec3apigateway.security.jwt;

import com.nasor.springbootmicroservicec3apigateway.model.User;
import com.nasor.springbootmicroservicec3apigateway.security.UserPrincipal;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;

public interface JwtProvider {
    String generateToken(UserPrincipal auth);

    String generateToken(User user);

    Authentication getAuthentication(HttpServletRequest request);

    boolean validateToken(HttpServletRequest request);
}
