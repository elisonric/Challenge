package br.com.challenge.creditscore.config;

import br.com.challenge.core.property.JwtConfiguration;
import br.com.challenge.secutiry.config.SecurityTokenConfig;
import br.com.challenge.secutiry.filter.JwtTokenAuthorizationFilter;
import br.com.challenge.secutiry.token.converter.TokenConverter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityCredentialConfig extends SecurityTokenConfig {
    private final TokenConverter tokenConverter;

    public SecurityCredentialConfig(JwtConfiguration jwtConfiguration, TokenConverter tokenConverter) {
        super(jwtConfiguration);
        this.tokenConverter = tokenConverter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterAfter(new JwtTokenAuthorizationFilter(jwtConfiguration, tokenConverter), UsernamePasswordAuthenticationFilter.class);
        super.configure(http);
    }
}