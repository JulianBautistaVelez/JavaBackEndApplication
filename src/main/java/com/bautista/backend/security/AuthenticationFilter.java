package com.bautista.backend.security;

import com.bautista.backend.data.usuario.UsuarioEntity;
import com.bautista.backend.model.usuario.LogingRequestModel;
import com.bautista.backend.service.usuario.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    Environment environment;

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
            throw new RuntimeException(exc);
        }
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain,
            Authentication authResult) throws IOException, ServletException {

        //TODO REVISAR
        String userName = ((User) authResult.getPrincipal()).getUsername();

        UsuarioEntity usuario = usuarioService.getUsuarioByNombre(userName);

        String token = Jwts.builder()
                .setSubject(usuario.getUsuarioId())
                .setExpiration(
                        new Date(
                                System.currentTimeMillis() +
                                        Long.parseLong(
                                                "60480000"
                                                //environment.getProperty("token.expiration.time")
                                        )
                        )
                )
                .signWith(
                        SignatureAlgorithm.HS512, environment.getProperty(
                                "354sad123lmjad1251222a123<"
                                //"token.secret.signature"
                        )
                )
                .compact();

        response.addHeader("token",token);
        response.addHeader("usuarioId", usuario.getUsuarioId());

    }
}
