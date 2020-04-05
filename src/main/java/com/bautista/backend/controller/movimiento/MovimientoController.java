package com.bautista.backend.controller.movimiento;

import com.bautista.backend.model.movimiento.MovimientoRequestModel;
import com.bautista.backend.model.movimiento.MovimientoResponseModel;
import com.bautista.backend.model.shared.RangeOfTimeRequest;
import com.bautista.backend.service.movimiento.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/movimientos")
public class MovimientoController {

    @Autowired
    MovimientoService service;

    @GetMapping("/get")
    public List<MovimientoResponseModel> getAll(){
        return service.getAll();
    }

    @PostMapping("/get/rot")
    public List<MovimientoResponseModel> getAllROT(@RequestBody RangeOfTimeRequest request ){
        return service.getAllROT(request);
    }

    @GetMapping("get/{id}")
    public MovimientoResponseModel getById(@PathVariable("id") String id){
        return service.findById(id);
    }

    @PostMapping(value = "insert/multiple")
    public void insertMultipleMovimiento(@Valid @RequestBody MovimientoRequestModel[] request){
        for (MovimientoRequestModel movimiento: request ) {
            service.insert(movimiento);
        }

    }

    @PostMapping(value = "/insert")
    public void insertMovimiento(@Valid @RequestBody MovimientoRequestModel request){
        service.insert(request);
    }

    @PutMapping("/update/{id}")
    public void updateMovimiento(@PathVariable("id") String id, @Valid @RequestBody MovimientoRequestModel request){
        service.update(request, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMovimiento(@PathVariable("id") String id){
        service.delete(id);
    }

    @PostMapping("/get/{tipoMovimiento}/rot")
    public List<MovimientoResponseModel> getGastos(@PathVariable("tipoMovimiento") String tipoMovimiento, @Valid @RequestBody RangeOfTimeRequest request){
        return service.getMovimentosROT(request, tipoMovimiento);
    }

}
