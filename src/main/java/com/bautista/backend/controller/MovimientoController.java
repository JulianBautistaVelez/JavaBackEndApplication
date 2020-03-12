package com.bautista.backend.controller;

import com.bautista.backend.model.movimiento.MovimientoRequestModel;
import com.bautista.backend.model.movimiento.MovimientoResponseModel;
import com.bautista.backend.service.movimiento.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping(value = "/insert-movimento", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void insertMovimiento(@Valid @RequestBody MovimientoRequestModel request){
        service.insert(request);
    }
}
