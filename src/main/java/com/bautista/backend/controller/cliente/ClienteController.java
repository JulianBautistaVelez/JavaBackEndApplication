package com.bautista.backend.controller.cliente;

import com.bautista.backend.model.cliente.ClienteRequestModel;
import com.bautista.backend.model.cliente.ClienteResponseModel;
import com.bautista.backend.service.cliente.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    ClienteService service;

    @GetMapping("/get-todos")
    public List<ClienteResponseModel> getAll(){
        List<ClienteResponseModel> returnValue = service.getAll();
        return  returnValue;
    }

    @PostMapping("/insert-cliente")
    public void insertCliente(@Valid @RequestBody ClienteRequestModel request){
        service.insert(request);
    }
}
