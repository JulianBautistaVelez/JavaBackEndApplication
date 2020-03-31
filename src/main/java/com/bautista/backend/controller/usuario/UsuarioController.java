package com.bautista.backend.controller.usuario;

import com.bautista.backend.model.usuario.UsuarioRequestModel;
import com.bautista.backend.service.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @PostMapping("/create")
    public ResponseEntity createUsuario(@Valid @RequestBody UsuarioRequestModel usuario){
        this.service.createUser(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario Creado");
    }
}
