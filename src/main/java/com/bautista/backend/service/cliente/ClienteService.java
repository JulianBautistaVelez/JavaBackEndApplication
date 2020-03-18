package com.bautista.backend.service.cliente;

import com.bautista.backend.data.cliente.ClienteEntity;
import com.bautista.backend.data.cliente.ClienteRepository;
import com.bautista.backend.model.cliente.ClienteRequestModel;
import com.bautista.backend.model.cliente.ClienteResponseModel;
import com.bautista.backend.service.ServiceInterface;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class ClienteService
        implements ServiceInterface<ClienteResponseModel, ClienteRequestModel> {

    @Autowired
    private ClienteRepository respository;

    private ModelMapper modelMapper;

    public ClienteService(){
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public ClienteResponseModel getLastEntry() {
        ClienteEntity dbData = respository.findTopByOrderByIdDesc();
        ClienteResponseModel response = modelMapper.map(dbData, ClienteResponseModel.class);
        return response;
    }

    @Override
    public List<ClienteResponseModel> getAll() {
        List<ClienteEntity> dbData = respository.findAllBy();
        List<ClienteResponseModel> response =
                Arrays.asList(modelMapper.map(dbData, ClienteResponseModel[].class));
        return null;
    }

    @Override
    public void insert(ClienteRequestModel cliente) {
        ClienteEntity clienteEntity = modelMapper.map(cliente, ClienteEntity.class);
        clienteEntity.setClienteId(UUID.randomUUID().toString());
        respository.save(clienteEntity);
    }

    @Override
    public ClienteResponseModel findById(String id) {
        //TODO implementar
        return null;
    }

    @Override
    public void update(ClienteRequestModel requestModel, String String) {

    }

    @Override
    public void delete(String id) {

    }

}
