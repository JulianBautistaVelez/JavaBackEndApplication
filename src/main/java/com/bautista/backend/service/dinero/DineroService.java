package com.bautista.backend.service.dinero;

import com.bautista.backend.data.dinero.DineroEntity;
import com.bautista.backend.data.dinero.DineroRepository;
import com.bautista.backend.model.dinero.DineroResponseModel;
import com.bautista.backend.service.ServiceInterface;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DineroService implements ServiceInterface {

    @Autowired
    DineroRepository repository;

    private ModelMapper modelMapper;
    public DineroService(){
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public DineroResponseModel getLastEntry() {
        DineroEntity dbData = repository.findTopByOrderByIdDesc();
        DineroResponseModel response = modelMapper.map(dbData, DineroResponseModel.class);
        return response;
    }

    @Override
    public Object getAll() {
        /*TODO implementar*/
        return null;
    }
}
