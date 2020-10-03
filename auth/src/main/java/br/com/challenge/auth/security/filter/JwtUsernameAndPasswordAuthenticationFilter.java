package br.com.challenge.auth.security.filter;

import br.com.challenge.core.property.JwtConfiguration;
import br.com.challenge.secutiry.token.creator.TokenCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.jwt.SignedJWT;
import entity.ApplicationUser;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

import static java.util.Collections.emptyList;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class JwtUsernameAndPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    private final JwtConfiguration jwtConfiguration;
    private final TokenCreator tokenCreator;

    @Override
    @SneakyThrows
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        log.info("Attempting authentication. . .");
        ApplicationUser applicationUser = new ObjectMapper().readValue(request.getInputStream(), ApplicationUser.class);

        if (Objects.isNull(applicationUser)) {
            throw new UsernameNotFoundException("Unable to retrieve the username or password");
        }
        log.info("Creating the authentication object for the user '{}' and calling UserDetailServiceImpl loadUserByUsername", applicationUser.getUsername());

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());
        usernamePasswordAuthenticationToken.setDetails(applicationUser);

        return  authenticationManager.authenticate(usernamePasswordAuthenticationToken);
    }

    @Override
    @SneakyThrows
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication auth) {
        log.info("Authentication was sucessful for the user '{}', generating JWT token", auth.getName());

        SignedJWT signedJWT = tokenCreator.createSignedJWT(auth);
        String encryptedToken = tokenCreator.encryptToken(signedJWT);
        log.info("Token generated successfully, adding it to the response header");

        response.addHeader("Access-Control-Expose-Headers", "XSRF-TOKEN, "+jwtConfiguration.getHeader().getName());
        response.addHeader(jwtConfiguration.getHeader().getName(), jwtConfiguration.getHeader().getPrefix() + encryptedToken);
    }
}
