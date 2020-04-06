package com.bautista.backend.configuration;

import com.bautista.backend.data.usuario.UsuarioEntity;
import com.bautista.backend.data.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@DependsOn({"bCryptPasswordEncoder"})
public class ApplicationInitializer implements ApplicationListener<WebServerInitializedEvent > {
    private static final Logger logger = Logger.getLogger(ApplicationInitializer.class.getName());

    UsuarioRepository usuarioRepository;
    Environment environment;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public ApplicationInitializer(
            UsuarioRepository usuarioRepository,
            Environment environment,
            BCryptPasswordEncoder bCryptPasswordEncoder){
        super();
        this.usuarioRepository = usuarioRepository;
        this.environment = environment;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void onApplicationEvent(WebServerInitializedEvent WebServerInitializedEvent) {
        UsuarioEntity usuarioUnico = new UsuarioEntity();
        usuarioUnico.setEncryptedPassword(bCryptPasswordEncoder.encode(environment.getProperty("user.plain.password")));
        usuarioUnico.setNombre(environment.getProperty("user.username"));
        usuarioUnico.setUsuarioId(UUID.randomUUID().toString());

        logger.log(Level.ALL, "Creando usuario unico");

        usuarioRepository.save(usuarioUnico);
    }
}
