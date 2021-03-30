package com.belstu.thesisproject.authservice.config;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "auth")
@RequiredArgsConstructor
@Data
public class JwtConfig {
    @Value("${security.jwt.uri:/auth/**}")
    private final String Uri;

    @Value("${security.jwt.header:Authorization}")
    private final String header;

    @Value("${security.jwt.prefix:Bearer }")
    private final String prefix;

    @Value("${security.jwt.expiration:#{24*60*60}}")
    private final int expiration;

    @Value("${security.jwt.secret:JwtSecretKey}")
    private final String secret;
}