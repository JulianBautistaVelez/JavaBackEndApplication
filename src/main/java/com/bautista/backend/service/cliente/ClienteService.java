package com.bautista.backend.service.cliente;

import com.bautista.backend.data.cliente.ClienteEntity;
import com.bautista.backend.data.cliente.ClienteRepository;
import com.bautista.backend.model.cliente.ClienteRequestModel;
import com.bautista.backend.model.cliente.ClienteResponseModel;
import com.bautista.backend.model.shared.RangeOfTimeRequest;
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
    private ClienteServiceHelper helper;

    public ClienteService(){
        helper = new ClienteServiceHelper();
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
        return response;
    }

    @Override
    public List<ClienteResponseModel> getAllROT(RangeOfTimeRequest request) {
        //TODO implementar
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
        ClienteEntity dbData = respository.findByClienteId(id);
        ClienteResponseModel response = null;
        if(dbData != null){
            response = modelMapper.map(dbData, ClienteResponseModel.class);
        }
        return response;
    }

    @Override
    public void update(ClienteRequestModel cliente, String id) {
        ClienteEntity dbData = respository.findByClienteId(id);
        if(dbData != null){
            ClienteEntity update = modelMapper.map(cliente, ClienteEntity.class);
            helper.copyFieldsFromTo(update, dbData);
            respository.save(dbData);
        }
    }

    @Override
    public void delete(String id) {
        ClienteEntity clienteDeleted = respository.findByClienteId(id);
        if(clienteDeleted != null){
            respository.delete(clienteDeleted);
        }
    }

}
