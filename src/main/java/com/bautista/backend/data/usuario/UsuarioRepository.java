package com.bautista.backend.data.usuario;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Long> {

    UsuarioEntity findByNombre(String nombre);

}
