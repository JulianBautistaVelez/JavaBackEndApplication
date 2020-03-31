package com.bautista.backend.service.dinero;

import com.bautista.backend.data.dinero.DineroEntity;
import com.bautista.backend.data.dinero.DineroRepository;
import com.bautista.backend.model.dinero.DineroRequestModel;
import com.bautista.backend.model.dinero.DineroResponseModel;
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
public class DineroService
        implements ServiceInterface<DineroResponseModel, DineroRequestModel> {

    @Autowired
    DineroRepository dineroRepository;

    private ModelMapper modelMapper;
    public DineroService(){
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public DineroResponseModel getLastEntry() {
        DineroEntity dbData = dineroRepository.findTopByOrderByIdDesc();
        DineroResponseModel response = modelMapper.map(dbData, DineroResponseModel.class);
        return response;
    }

    @Override
    public List<DineroResponseModel> getAll() {
        List<DineroEntity> dbData = dineroRepository.findAllBy();
        List<DineroResponseModel> response =
                Arrays.asList(modelMapper.map(dbData, DineroResponseModel[].class));
        return null;
    }

    @Override
    public List<DineroResponseModel> getAllROT(RangeOfTimeRequest request) {
        //TODO implementar
        return null;
    }

    @Override
    public void insert(DineroRequestModel dinero) {
        DineroEntity dineroEntity = modelMapper.map(dinero, DineroEntity.class);
        dineroEntity.setDineroId(UUID.randomUUID().toString());
        dineroRepository.save(dineroEntity);
    }

    @Override
    public DineroResponseModel findById(String id) {
        DineroEntity dbData = dineroRepository.findByDineroId(id);
        DineroResponseModel response = null;
        if(dbData != null){
            response = modelMapper.map(dbData, DineroResponseModel.class);
        }
        return response;
    }

    @Override
    public void update(DineroRequestModel requestModel, String String) {
        //TODO decidir que hacer aquí
    }

    @Override
    public void delete(String id) {
        DineroEntity dineroDeleted = dineroRepository.findByDineroId(id);
        if(dineroDeleted != null){
            dineroRepository.delete(dineroDeleted);
        }
    }

}
