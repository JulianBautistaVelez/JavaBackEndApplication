package com.bautista.backend.model.informacion.gastos;

import com.bautista.backend.data.movimiento.MovimientoEntity;
import com.bautista.backend.model.informacion.PieChartResponseModel;

import java.util.List;

public class GastosResponseModel extends PieChartResponseModel {
    public GastosResponseModel(List<MovimientoEntity> movimientos) {
        super(movimientos);
    }
}
