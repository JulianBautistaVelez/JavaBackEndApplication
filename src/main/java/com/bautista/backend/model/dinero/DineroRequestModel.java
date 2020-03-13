package com.bautista.backend.model.dinero;

import java.util.Date;

public class DineroRequestModel {
    private float banco;
    private float caja;

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
}
