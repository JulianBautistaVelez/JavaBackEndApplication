package com.bautista.backend.model.dinero;

import java.util.Date;

public class DineroResponseModel {

    private float banco;
    private float caja;
    private Date fecha;
    private String dineroId;

    public float getBanco() {
        return banco;
    }

    public void setBanco(float banco) {
        this.banco = banco;
    }

    public float getCaja() {
        return caja;
    }

    public void setCaja(float caja) {
        this.caja = caja;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDineroId() {
        return dineroId;
    }

    public void setDineroId(String dineroId) {
        this.dineroId = dineroId;
    }
}
