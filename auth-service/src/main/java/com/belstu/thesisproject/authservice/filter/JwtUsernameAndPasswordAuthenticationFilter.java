package com.belstu.thesisproject.authservice.filter;

import com.belstu.thesisproject.authservice.config.JwtConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import lombok.Data;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;

import static io.jsonwebtoken.SignatureAlgorithm.HS512;
import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpMethod.POST;

public class JwtUsernameAndPasswordAuthenticationFilter
        extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authManager;
    private final ObjectMapper objectMapper;
    private final JwtConfig jwtConfig;

    public JwtUsernameAndPasswordAuthenticationFilter(
            AuthenticationManager authManager, ObjectMapper objectMapper, JwtConfig jwtConfig) {
        this.authManager = authManager;
        this.objectMapper = objectMapper;
        this.jwtConfig = jwtConfig;
        this.setRequiresAuthenticationRequestMatcher(
                new AntPathRequestMatcher(jwtConfig.getUri(), POST.name()));
    }

    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            final UserCredentials credentials =
                    objectMapper.readValue(request.getInputStream(), UserCredentials.class);
            final Authentication authToken =
                    new UsernamePasswordAuthenticationToken(
                            credentials.getUsername(), credentials.getPassword(), Collections.emptyList());
            return authManager.authenticate(authToken);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain,
            Authentication auth){

        Long now = System.currentTimeMillis();
        String token =
                Jwts.builder()
                        .setSubject(auth.getName())
                        .claim(
                                "authorities",
                                auth.getAuthorities().stream()
                                        .map(GrantedAuthority::getAuthority)
                                        .collect(toList()))
                        .setIssuedAt(new Date(now))
                        .setExpiration(new Date(now + jwtConfig.getExpiration() * 1000))
                        .signWith(HS512, jwtConfig.getSecret().getBytes())
                        .compact();
        response.addHeader(jwtConfig.getHeader(), jwtConfig.getPrefix() + token);
    }

    @Data
    private static class UserCredentials {
        private String username, password;
    }
}
