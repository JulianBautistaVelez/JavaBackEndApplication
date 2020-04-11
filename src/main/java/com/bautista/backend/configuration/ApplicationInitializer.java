package com.bautista.backend.configuration;

import com.bautista.backend.data.dinero.DineroEntity;
import com.bautista.backend.data.dinero.DineroRepository;
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

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    DineroRepository dineroRepository;

    @Autowired
    Environment environment;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void onApplicationEvent(WebServerInitializedEvent WebServerInitializedEvent) {
        createFirstDineroState();
        createFirstUser();
    }

    private void createFirstDineroState(){
        if(dineroRepository.count() == 0){
            DineroEntity dineroEntity = new DineroEntity();

            dineroEntity.setCaja(0f);
            dineroEntity.setBanco(0f);

            dineroRepository.save(dineroEntity);
        }
    }

    private void createFirstUser(){
        if(usuarioRepository.count() == 0){
            UsuarioEntity usuarioUnico = new UsuarioEntity();
            usuarioUnico.setEncryptedPassword(bCryptPasswordEncoder.encode(environment.getProperty("user.plain.password")));
            usuarioUnico.setNombre(environment.getProperty("user.username"));
            usuarioUnico.setUsuarioId(UUID.randomUUID().toString());

            logger.log(Level.ALL, "Creando usuario unico");

            usuarioRepository.save(usuarioUnico);
        }
    }
}
