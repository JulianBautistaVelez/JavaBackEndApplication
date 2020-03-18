package com.bautista.backend.controller.movimiento;

import com.bautista.backend.model.movimiento.MovimientoRequestModel;
import com.bautista.backend.model.movimiento.MovimientoResponseModel;
import com.bautista.backend.service.movimiento.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping(value = "/insert-movimento")
    public void insertMovimiento(@Valid @RequestBody MovimientoRequestModel request){
        service.insert(request);
    }

    @PutMapping("/update-movimiento/{id}")
    public void updateMovimiento(@PathVariable("id") String id, @Valid @RequestBody MovimientoRequestModel request){
        service.update(request, id);
    }

    @DeleteMapping("/delete-movimiento/{id}")
    public void deleteMovimiento(@PathVariable("id") String id){
        service.delete(id);
    }
}
