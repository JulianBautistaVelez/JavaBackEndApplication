package com.bautista.backend.model.factura.fila;

import javax.validation.constraints.NotNull;

public class FilaRequestModel {

    @NotNull(message = "Es obligatorio introducir un concepto")
    private String concepto;

    @NotNull(message = "Es obligatorio itroducir un valor unitario")
    private Float valor;

    @NotNull(message = "Es obligatorio introducir un número de unidades")
    private int unidades;

    private Float valorTotal;

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }
}
