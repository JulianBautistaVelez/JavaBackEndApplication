package com.bautista.backend.service.usuario;

import com.bautista.backend.data.usuario.UsuarioEntity;
import com.bautista.backend.data.usuario.UsuarioRepository;
import com.bautista.backend.model.usuario.UsuarioRequestModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    ModelMapper modelMapper;

    public UsuarioService(){
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public void createUser(UsuarioRequestModel usuario){
        UsuarioEntity usuarioEntity = modelMapper.map(usuario, UsuarioEntity.class);

        usuarioEntity.setUsuarioId(UUID.randomUUID().toString());
        usuarioEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));

        repository.save(usuarioEntity);

    }

    public UsuarioEntity getUsuarioByNombre(String nombre){
        UsuarioEntity usuario = repository.findByNombre(nombre);
        if(usuario == null) throw new UsernameNotFoundException(nombre);
        return usuario;
    }

    @Override
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        UsuarioEntity usuario = repository.findByNombre(nombre);
        if(usuario == null) throw new UsernameNotFoundException(nombre);

        return new User(
                usuario.getNombre(),
                usuario.getEncryptedPassword(),
                true,
                true,
                true,
                true,
                new ArrayList<>()
        );
    }
}
