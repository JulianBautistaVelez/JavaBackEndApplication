package com.bautista.backend.controller.dinero;

import com.bautista.backend.model.dinero.DineroResponseModel;
import com.bautista.backend.service.dinero.DineroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*TODO pensar en añadir una relación con el movimiento que causa el cambio de estado de liquidez
    puede ser útil para tener una vista mas clara del estado actual
 */

@RestController
@RequestMapping(
        value="api/dinero",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class DineroController {

    @Autowired
    DineroService dineroService;

    @GetMapping("/get-dinero-actual")
    public ResponseEntity getDineroActual(){
        DineroResponseModel returnValue = dineroService.getLastEntry();
        return ResponseEntity.status(HttpStatus.OK).body(returnValue);
    }
}
