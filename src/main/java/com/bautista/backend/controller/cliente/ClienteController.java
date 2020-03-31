package com.bautista.backend.controller.cliente;

import com.bautista.backend.model.cliente.ClienteRequestModel;
import com.bautista.backend.model.cliente.ClienteResponseModel;
import com.bautista.backend.service.cliente.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(
        value = "clientes",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class ClienteController {

    @Autowired
    ClienteService service;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        List<ClienteResponseModel> body = service.getAll();
        return  ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @GetMapping("/get/{id}")
    public ClienteResponseModel getById(@PathVariable("id") String id) { return service.findById(id);}

    @PostMapping("/insert")
    public void insertCliente(@Valid @RequestBody ClienteRequestModel request){
        service.insert(request);
    }

    @PutMapping("/update/{id}")
    public void updateCliente(@PathVariable("id") String id, @RequestBody ClienteRequestModel request){
        service.update(request, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClient(@PathVariable("id") String id){
        service.delete(id);
    }
}
