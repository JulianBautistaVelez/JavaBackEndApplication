package com.bautista.backend.service.factura;

import com.bautista.backend.data.factura.factura.FacturaEntity;
import com.bautista.backend.data.factura.fila.FilaFacturaEntity;
import org.modelmapper.ModelMapper;

import java.util.Arrays;

//TODO repensar esta clase, no debe tener atributos y luego métodos que no tienen nada que ver con ella
public class FacturaServiceHelper {

    private float base;
    private float iva;
    private float total;
    private float ivaPorcentaje;

    public FacturaServiceHelper(float ivaPorcentaje){
        this.ivaPorcentaje = ivaPorcentaje;
    }



    public void calculateExtraInfo(FacturaEntity factura){
        this.base = 0;
        this.total = 0;
        this.iva = 0;
        for ( FilaFacturaEntity fila: factura.getFilas()
             ) {
            this.base += fila.getValorTotal();
            this.iva += fila.getValorTotal()* ivaPorcentaje;
        }
        this.total = base + iva;
    }

    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public float getTotal() {
        return this.total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "FacturaServiceHelper{" +
                "base=" + base +
                ", iva=" + iva +
                ", total=" + total +
                '}';
    }

    public void copyFieldsFromTo(
            FacturaEntity factura,
            FacturaEntity dbData,
            ModelMapper modelMapper){
        this.calculateExtraInfo(factura);
        dbData.setNombre(factura.getNombre());
        dbData.setIva(this.getIva());
        dbData.setBase(this.getBase());
        dbData.setCpProvincia(factura.getCpProvincia());
        dbData.setDireccion(factura.getDireccion());
        dbData.setFecha(factura.getFecha());
        dbData.setNif(factura.getNif());
        dbData.setFilas(
                Arrays.asList(
                        modelMapper.map(factura.getFilas(), FilaFacturaEntity[].class)));
    }
}
