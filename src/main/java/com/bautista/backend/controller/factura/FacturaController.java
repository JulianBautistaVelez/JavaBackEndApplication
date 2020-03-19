package com.bautista.backend.controller.factura;

import com.bautista.backend.model.factura.factura.FacturaRequestModel;
import com.bautista.backend.model.factura.factura.FacturaResponseModel;
import com.bautista.backend.service.factura.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("facturas")
public class FacturaController {

    @Autowired
    FacturaService service;

    @GetMapping("/get")
    public List<FacturaResponseModel> getAll(){
        List<FacturaResponseModel> returnValue = service.getAll();
        return returnValue;
    }

    @PostMapping("/insert")
    public void insertaFactura(@Valid @RequestBody FacturaRequestModel request){
        service.insert(request);
    }

    @GetMapping("/get/{id}")
    public FacturaResponseModel getById(@PathVariable("id") String id){
        return service.findById(id);
    }

    @PutMapping("update/{id}")
    public void updateFactura(@PathVariable("id") String id, @Valid @RequestBody FacturaRequestModel request){
        service.update(request, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFactura(@PathVariable("id") String id){
        service.delete(id);
    }
}
