package com.bautista.backend.model.informacion.ingresos;

import com.bautista.backend.data.movimiento.MovimientoEntity;
import com.bautista.backend.model.informacion.PieChartResponseModel;

import java.util.List;

public class IngresosResponseModel extends PieChartResponseModel {
    public IngresosResponseModel(List<MovimientoEntity> movimientos) {
        super(movimientos);
    }
}
