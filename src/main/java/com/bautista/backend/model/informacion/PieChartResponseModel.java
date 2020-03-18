package com.bautista.backend.model.informacion;

import com.bautista.backend.data.movimiento.MovimientoEntity;

import java.util.LinkedHashMap;
import java.util.List;

public class PieChartResponseModel {
    private LinkedHashMap<String, Float> data = new LinkedHashMap();

    public PieChartResponseModel(List<MovimientoEntity> movimientos){
        for (MovimientoEntity movimiento: movimientos) {
            String concepto = movimiento.getConcepto();
            int blankPosition =
                    concepto.indexOf(' ') == -1? concepto.length(): concepto.indexOf(' ');
            String key = concepto.substring(0, blankPosition);
            float lastSum = data.get(key) == null? 0 : data.get(key);
            data.put(key, lastSum + movimiento.getValor());
        }
    }

    public LinkedHashMap<String, Float> getData(){
        return data;
    }

    public void setData(LinkedHashMap<String, Float> data){
        this.data = data;
    }
}
