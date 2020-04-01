package com.bautista.backend.service.usuario;

import com.bautista.backend.data.usuario.UsuarioEntity;
import com.bautista.backend.model.usuario.UsuarioRequestModel;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsuarioService extends UserDetailsService {
    public void createUser(UsuarioRequestModel usuario);
    public UsuarioEntity getUsuarioByNombre(String nombre);
    public UserDetails loadUserByUsername(String nombre);
}
