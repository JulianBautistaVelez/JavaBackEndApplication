package com.bautista.backend.controller.dinero;

import com.bautista.backend.model.dinero.DineroResponseModel;
import com.bautista.backend.service.dinero.DineroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/*TODO pensar en añadir una relación con el movimiento que causa el cambio de estado de liquidez
    puede ser útil para tener una vista mas clara del estado actual
 */

@RestController
@RequestMapping("dinero")
public class DineroController {

    @Autowired
    DineroService dineroService;

    @GetMapping("/get-dinero-actual")
    public DineroResponseModel getDineroActual(){
        DineroResponseModel returnValue = dineroService.getLastEntry();
        return returnValue;
    }
}
