package com.bautista.backend.service.factura;

import com.bautista.backend.data.factura.factura.FacturaEntity;
import com.bautista.backend.data.factura.factura.FacturaRepository;
import com.bautista.backend.data.factura.fila.FilaFacturaEntity;
import com.bautista.backend.model.factura.factura.FacturaRequestModel;
import com.bautista.backend.model.factura.factura.FacturaResponseModel;
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
public class FacturaService
        implements ServiceInterface<FacturaResponseModel, FacturaRequestModel> {

    @Autowired
    private FacturaRepository repository;

    private FacturaServiceHelper helper;

    private ModelMapper modelMapper;

    private float ivaPorcentaje;


    public FacturaService(){
        ivaPorcentaje = 0.21f;
        helper = new FacturaServiceHelper(ivaPorcentaje);
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public FacturaResponseModel getLastEntry() {
        FacturaEntity dbData = repository.findTopByOrderByFechaDesc();
        FacturaResponseModel response = modelMapper.map(dbData, FacturaResponseModel.class);
        return response;
    }

    @Override
    public List<FacturaResponseModel> getAll() {
        List<FacturaEntity> dbData = repository.findAllBy();
        List<FacturaResponseModel> response =
                Arrays.asList(modelMapper.map(dbData, FacturaResponseModel[].class));
        return response;
    }

    @Override
    public List<FacturaResponseModel> getAllROT(RangeOfTimeRequest fechas) {
        List<FacturaEntity> dbData = repository.findAllROTBy(fechas.getFechaInicio(), fechas.getFechaFin());
        List<FacturaResponseModel> response =
                Arrays.asList(modelMapper.map(dbData, FacturaResponseModel[].class));
        return response;
    }

    @Override
    public void insert(FacturaRequestModel factura) {
        FacturaEntity facturaEntity = modelMapper.map(factura, FacturaEntity.class);
        helper.calculateExtraInfo(facturaEntity);
        facturaEntity.setBase(helper.getBase());
        facturaEntity.setIva(helper.getIva());
        facturaEntity.setTotal(helper.getTotal());

        facturaEntity.setFacturaId(UUID.randomUUID().toString());
        repository.save(facturaEntity);
    }

    @Override
    public FacturaResponseModel findById(String id) {
        FacturaEntity dbData = repository.findByFacturaId(id);
        FacturaResponseModel response = null;
        if(dbData != null){
            response = modelMapper.map(dbData, FacturaResponseModel.class);
        }
        return response;
    }

    @Override
    public void update(FacturaRequestModel factura, String id) {
        FacturaEntity dbData = repository.findByFacturaId(id);
        if(dbData != null){
//            FacturaEntity facturaEntity = modelMapper.map(factura, FacturaEntity.class);
//            helper.copyFieldsFromTo(facturaEntity, dbData, modelMapper);

            FacturaEntity facturaEntity = modelMapper.map(factura, FacturaEntity.class);
            helper.calculateExtraInfo(facturaEntity);
            facturaEntity.setBase(helper.getBase());
            facturaEntity.setIva(helper.getIva());
            facturaEntity.setTotal(helper.getTotal());
            facturaEntity.setFacturaId(id);

            repository.delete(dbData);
            repository.save(facturaEntity);


        }
    }

    @Override
    public void delete(String id) {
        FacturaEntity facturaDeleted = repository.findByFacturaId(id);
        if(facturaDeleted != null){
            repository.delete(facturaDeleted);
        }
    }

}
