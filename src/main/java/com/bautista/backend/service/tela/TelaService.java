package com.bautista.backend.service.tela;

import com.bautista.backend.data.tela.TelaEntity;
import com.bautista.backend.data.tela.TelaRepository;
import com.bautista.backend.model.tela.TelaRequestModel;
import com.bautista.backend.model.tela.TelaResponseModel;
import com.bautista.backend.service.ServiceInterface;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class TelaService implements ServiceInterface<TelaResponseModel, TelaRequestModel> {

    @Autowired
    TelaRepository repository;

    private ModelMapper modelMapper;
    private TelaServiceHelper helper;

    public TelaService(){
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public TelaResponseModel getLastEntry() {
        TelaEntity dbData =  repository.findTopByOrderByIdDesc();
        TelaResponseModel response = modelMapper.map(dbData, TelaResponseModel.class);
        return response;
    }

    @Override
    public List<TelaResponseModel> getAll() {
        List<TelaEntity> dbData = repository.findAllBy();
        List<TelaResponseModel> response =
                Arrays.asList(modelMapper.map(dbData, TelaResponseModel[].class));
        return response;
    }

    @Override
    public void insert(TelaRequestModel tela) {
        TelaEntity telaEntity = modelMapper.map(tela, TelaEntity.class);
        telaEntity.setTelaId(UUID.randomUUID().toString());
        repository.save(telaEntity);
    }

    @Override
    public TelaResponseModel findById(String id) {
        TelaEntity dbData = repository.findByTelaId(id);
        TelaResponseModel response =null;
        if(dbData != null){
            response = modelMapper.map(dbData, TelaResponseModel.class);
        }
        return response;
    }

    @Override
    public void update(TelaRequestModel tela, String id) {
        TelaEntity dbData = repository.findByTelaId(id);
        if(dbData != null){
            TelaEntity update = modelMapper.map(tela, TelaEntity.class);
            helper.copyFieldsFromTo(update, dbData);
            repository.save(dbData);
        }

    }

    @Override
    public void delete(String id) {
        TelaEntity telaDeleted = repository.findByTelaId(id);
        if(telaDeleted != null ){
            repository.delete(telaDeleted);
        }
    }
}
