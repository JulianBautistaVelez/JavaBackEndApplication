package com.bautista.backend.controller.informacion;

import com.bautista.backend.model.informacion.gastos.GastosROTRequestModel;
import com.bautista.backend.model.informacion.gastos.GastosResponseModel;
import com.bautista.backend.model.informacion.ingresos.IngresosROTRequestModel;
import com.bautista.backend.model.informacion.liquidez.LiquidezROTRequestModel;
import com.bautista.backend.model.informacion.liquidez.LiquidezResponseModel;
import com.bautista.backend.service.informacion.InformacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("informacion")
public class InformacionController {

    @Autowired
    InformacionService service;

    @GetMapping("/get-liquidez")
    public LiquidezResponseModel getLiquidez(@RequestBody(required = false) LiquidezROTRequestModel request){
        LiquidezResponseModel response;
        if(request == null){
            response = service.getLiquidezInformation();
        } else {
            response = service.getLiquidezInformation(request);
        }
        return response;
    }

    @GetMapping("/get-gastos")
    public GastosResponseModel getGastos(@RequestBody GastosROTRequestModel request){
        return service.getGastos(request);
    }

    @GetMapping("/get-ingresos")
    public GastosResponseModel getIngresos(@RequestBody IngresosROTRequestModel request){
        return service.getIngresos(request);
    }
}
