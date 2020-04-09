package com.bautista.backend.controller.tela;

import com.bautista.backend.model.tela.TelaRequestModel;
import com.bautista.backend.model.tela.TelaResponseModel;
import com.bautista.backend.service.tela.TelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/telas")
public class TelaController {

    @Autowired
    TelaService service;

    @GetMapping("/get")
    public List<TelaResponseModel> getAll(){
        return  service.getAll();
    }

    @GetMapping("/get/{id}")
    public TelaResponseModel getById(@PathVariable("id") String id) { return service.findById(id);}

    @PostMapping("/insert")
    public void insertTela(@Valid @RequestBody TelaRequestModel request){
        service.insert(request);
    }

    @PutMapping("/update/{id}")
    public void updateTela(@PathVariable("id") String id, @RequestBody TelaRequestModel request){
        service.update(request, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClient(@PathVariable("id") String id){
        service.delete(id);
    }

}
