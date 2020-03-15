package com.bautista.backend.model.informacion.liquidez;

public class LiquidezFila {
    private float banco;
    private float caja;

    public LiquidezFila(){
        super();
    }

    public LiquidezFila(float banco, float caja){
        this.banco = banco;
        this.caja = caja;
    }

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
