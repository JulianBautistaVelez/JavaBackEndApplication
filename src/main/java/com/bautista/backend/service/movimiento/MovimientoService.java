package com.bautista.backend.service.movimiento;

import com.bautista.backend.data.movimiento.MovimientoEntity;
import com.bautista.backend.data.movimiento.MovimientoRepository;
import com.bautista.backend.model.movimiento.MovimientoResponseModel;
import com.bautista.backend.service.ServiceInterface;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovimientoService implements ServiceInterface {

    @Autowired
    private MovimientoRepository repository;

    private ModelMapper modelMapper;

    public MovimientoService(){
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public MovimientoResponseModel getLastEntry() {
        MovimientoEntity dbData = repository.findTopByOrderByFechaDesc();
        MovimientoResponseModel response = modelMapper.map(dbData, MovimientoResponseModel.class);
        return response;
    }

    @Override
    public List<MovimientoResponseModel> getAll() {
        List<MovimientoEntity> dbData = repository.findAllBy();
        List<MovimientoResponseModel> response = new ArrayList<>();
        response = modelMapper.map(dbData, response.getClass());
        return response;
    }
}
