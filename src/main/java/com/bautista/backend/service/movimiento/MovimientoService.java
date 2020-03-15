package com.bautista.backend.service.movimiento;

import com.bautista.backend.data.dinero.DineroEntity;
import com.bautista.backend.data.dinero.DineroRepository;
import com.bautista.backend.data.movimiento.DestinoMovimiento;
import com.bautista.backend.data.movimiento.MovimientoEntity;
import com.bautista.backend.data.movimiento.MovimientoRepository;
import com.bautista.backend.data.movimiento.TipoMovimiento;
import com.bautista.backend.model.movimiento.MovimientoRequestModel;
import com.bautista.backend.model.movimiento.MovimientoResponseModel;
import com.bautista.backend.service.ServiceInterface;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class MovimientoService
        implements ServiceInterface<MovimientoResponseModel, MovimientoRequestModel> {

    @Autowired
    private MovimientoRepository repository;

    @Autowired
    private DineroRepository dineroRepository;

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
        List<MovimientoResponseModel> response =
                Arrays.asList(modelMapper.map(dbData, MovimientoResponseModel[].class));
        return response;
    }

    @Override
    public void insert(MovimientoRequestModel movimiento){
        try {
            MovimientoEntity movimientoEntity = modelMapper.map(movimiento, MovimientoEntity.class);

            DineroEntity lastState = dineroRepository.findTopByOrderByIdDesc();
            DineroEntity actualizedState = lastState.copy();

            if(TipoMovimiento.ingreso.equals(movimiento.getTipo())){
                if(DestinoMovimiento.banco.equals(movimiento.getCajaBanco())) {
                    actualizedState.setBanco(lastState.getBanco() + movimiento.getValor());
                } else actualizedState.setCaja(lastState.getCaja() + movimiento.getValor());
            }
            if(TipoMovimiento.gasto.equals(movimiento.getTipo())){
                if(DestinoMovimiento.banco.equals(movimiento.getCajaBanco())) {
                    actualizedState.setBanco(lastState.getBanco() - movimiento.getValor());
                } else actualizedState.setCaja(lastState.getCaja() - movimiento.getValor());
            }

            actualizedState.setDineroId(UUID.randomUUID().toString());
            movimientoEntity.setMovimientoId(UUID.randomUUID().toString());
            repository.save(movimientoEntity);
            dineroRepository.save(actualizedState);
        }
        catch (Exception e) {
            //TODO controlar excepciones
            System.out.print(e);
        }

    }

    @Override
    public MovimientoResponseModel findById(String id) {
        //TODO implementar
        return null;
    }

}
