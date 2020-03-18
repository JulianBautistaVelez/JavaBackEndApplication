package com.bautista.backend.controller.informacion;

import com.bautista.backend.model.informacion.gastos.GastosRequestModel;
import com.bautista.backend.model.informacion.gastos.GastosResponseModel;
import com.bautista.backend.model.informacion.ingresos.IngresosRequestModel;
import com.bautista.backend.model.informacion.liquidez.LiquidezRequestModel;
import com.bautista.backend.model.informacion.liquidez.LiquidezResponseModel;
import com.bautista.backend.service.informacion.InformacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;

@RestController
@RequestMapping("informacion")
public class InformacionController {

    @Autowired
    InformacionService service;

    @GetMapping("/get-liquidez")
    public LiquidezResponseModel getLiquidez(@RequestBody(required = false) LiquidezRequestModel request){
        LiquidezResponseModel response;
        if(request == null){
            response = service.getLiquidezInformation();
        } else {
            response = service.getLiquidezInformation(request);
        }
        return response;
    }

    @GetMapping("/get-gastos")
    public GastosResponseModel getGastos(@RequestBody GastosRequestModel request){
        return service.getGastos(request);
    }

    @GetMapping("/get-ingresos")
    public GastosResponseModel getIngresos(@RequestBody IngresosRequestModel request){
        return service.getIngresos(request);
    }
}
