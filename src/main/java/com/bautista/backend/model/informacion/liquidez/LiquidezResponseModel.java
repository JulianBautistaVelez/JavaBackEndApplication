package com.bautista.backend.model.informacion.liquidez;

import com.bautista.backend.data.dinero.DineroEntity;

import java.util.Date;
import java.util.LinkedHashMap;

public class LiquidezResponseModel {

    private LinkedHashMap data = new LinkedHashMap<Date, LiquidezFila>();

    public void insertDineroEntity(DineroEntity dineroEntity){
        data.put(dineroEntity.getFecha(), new LiquidezFila(dineroEntity.getBanco(), dineroEntity.getCaja()));
    }

    public LinkedHashMap getData() {
        return data;
    }

    public void setData(LinkedHashMap data) {
        this.data = data;
    }
}
