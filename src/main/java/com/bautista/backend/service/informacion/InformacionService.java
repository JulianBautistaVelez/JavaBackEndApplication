package com.bautista.backend.service.informacion;

import com.bautista.backend.data.dinero.DineroEntity;
import com.bautista.backend.data.dinero.DineroRepository;
import com.bautista.backend.data.movimiento.MovimientoEntity;
import com.bautista.backend.data.movimiento.MovimientoRepository;
import com.bautista.backend.data.movimiento.TipoMovimiento;
import com.bautista.backend.model.informacion.gastos.GastosRequestModel;
import com.bautista.backend.model.informacion.gastos.GastosResponseModel;
import com.bautista.backend.model.informacion.ingresos.IngresosRequestModel;
import com.bautista.backend.model.informacion.liquidez.LiquidezRequestModel;
import com.bautista.backend.model.informacion.liquidez.LiquidezResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformacionService {

    @Autowired
    DineroRepository dineroRepository;

    @Autowired
    MovimientoRepository movimientoRepository;

    public LiquidezResponseModel getLiquidezInformation(){
        LiquidezResponseModel response = new LiquidezResponseModel();
        List<DineroEntity> dineroByDate = dineroRepository.findEndOfDay();

        for ( DineroEntity dinero: dineroByDate ) {
            response.insertDineroEntity(dinero);
        }

        return response;
    }

    public LiquidezResponseModel getLiquidezInformation(LiquidezRequestModel fechas){
        LiquidezResponseModel response = new LiquidezResponseModel();
        List<DineroEntity> dineroByDate =
                dineroRepository.findRangeOfTime(fechas.getFechaInicio(), fechas.getFechaFin());

        for ( DineroEntity dinero: dineroByDate ) {
            response.insertDineroEntity(dinero);
        }

        return response;
    }

    public GastosResponseModel getGastos(GastosRequestModel fechas){
        List<MovimientoEntity> dataToFormat =
                movimientoRepository.findMovimientosRangeOfTime(
                        fechas.getFechaInicio(),
                        fechas.getFechaFin(),
                        TipoMovimiento.gasto.toString());

        return new GastosResponseModel(dataToFormat);
    }

    public GastosResponseModel getIngresos(IngresosRequestModel fechas){
        List<MovimientoEntity> dataToFormat =
                movimientoRepository.findMovimientosRangeOfTime(
                        fechas.getFechaInicio(),
                        fechas.getFechaFin(),
                        TipoMovimiento.ingreso.toString());

        return new GastosResponseModel(dataToFormat);
    }

}
