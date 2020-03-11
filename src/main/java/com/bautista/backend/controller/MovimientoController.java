package com.bautista.backend.controller;

import com.bautista.backend.model.movimiento.MovimientoResponseModel;
import com.bautista.backend.service.movimiento.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("movimientos")
public class MovimientoController {

    @Autowired
    MovimientoService service;

    @GetMapping("/get-todos")
    public List<MovimientoResponseModel> getAll(){
        List<MovimientoResponseModel> returnValue = service.getAll();
        return returnValue;
    }
}
