package com.bautista.backend.model.movimiento;

import com.bautista.backend.data.movimiento.DestinoMovimiento;
import com.bautista.backend.data.movimiento.TipoMovimiento;

import java.util.Date;

public class MovimientoResponseModel {


    /*TODO necesito codificar el id para que no se transmita como enteros
    faciles de entender
     */
    private long id;
    private String concepto;
    private TipoMovimiento tipo;
    private Float valor;
    private DestinoMovimiento caja_banco;
    private Date fecha;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public TipoMovimiento getTipo() {
        return tipo;
    }

    public void setTipo(TipoMovimiento tipo) {
        this.tipo = tipo;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public DestinoMovimiento getCaja_banco() {
        return caja_banco;
    }

    public void setCaja_banco(DestinoMovimiento caja_banco) {
        this.caja_banco = caja_banco;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
