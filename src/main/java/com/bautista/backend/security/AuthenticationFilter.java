package com.bautista.backend.security;

import com.bautista.backend.data.usuario.UsuarioEntity;
import com.bautista.backend.model.usuario.LogingRequestModel;
import com.bautista.backend.service.usuario.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter{

    UsuarioService usuarioService;
    Environment environment;
    ObjectMapper objectMapper;

    @Autowired
    public AuthenticationFilter (
            UsuarioService usuarioService,
            Environment environment,
            AuthenticationManager authenticationManager,
            ObjectMapper objectMapper){
        super();
        this.usuarioService = usuarioService;
        this.environment = environment;
        this.objectMapper = objectMapper;
        super.setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest request,
            HttpServletResponse response) throws AuthenticationException {
        try {
            LogingRequestModel login = new ObjectMapper().readValue(
                    request.getInputStream(),
                    LogingRequestModel.class
            );

            return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(
                            login.getUsuario(),
                            login.getPassword(),
                            new ArrayList<>()
                    )
            );
        } catch (IOException exc){
            throw new RuntimeException("Usuario o contraseña erroneo",exc);
        }
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain,
            Authentication authResult) throws IOException, ServletException {

        String userName = ((User) authResult.getPrincipal()).getUsername();

        UsuarioEntity usuario = usuarioService.getUsuarioByNombre(userName);

        String token = Jwts.builder()
                .setSubject(usuario.getUsuarioId())
                .setExpiration(
                        new Date(
                                System.currentTimeMillis() +
                                        Long.parseLong(
                                                environment.getProperty("token.expiration.time")
                                        )
                        )
                )
                .signWith(
                        SignatureAlgorithm.HS512, environment.getProperty("token.secret.signature")
                )
                .compact();

//        objectMapper.writeValue(response.getWriter(), usuario.getUsuarioId());
        response.addHeader("access-control-expose-headers", "*");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("token",token);
        response.addHeader("usuarioId", usuario.getUsuarioId());

    }
}
