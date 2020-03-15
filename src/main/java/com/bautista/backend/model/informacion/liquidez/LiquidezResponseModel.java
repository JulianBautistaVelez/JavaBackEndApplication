package com.bautista.backend.model.informacion.liquidez;

import com.bautista.backend.data.dinero.DineroEntity;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Set;

public class LiquidezResponseModel {

    private LinkedHashMap data = new LinkedHashMap<Date, LiquidezFila>();

    public void insertDineroEntity(DineroEntity dineroEntity){
        data.put(dineroEntity.getFecha(), new LiquidezFila(dineroEntity.getBanco(), dineroEntity.getCaja()));
    }

    public Set<Date> getKeys(){
        return data.keySet();
    }

    public Set<LiquidezFila> getFilas(){
        return data.entrySet();
    }

    public LinkedHashMap getData() {
        return data;
    }

    public void setData(LinkedHashMap data) {
        this.data = data;
    }
}
