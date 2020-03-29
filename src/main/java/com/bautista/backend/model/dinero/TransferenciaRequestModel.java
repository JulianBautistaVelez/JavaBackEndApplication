package com.bautista.backend.model.dinero;

public class TransferenciaRequestModel {
    private float dinero;
    private String destino;

    public float getDinero() {
        return dinero;
    }

    public void setDinero(float dinero) {
        this.dinero = dinero;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}
