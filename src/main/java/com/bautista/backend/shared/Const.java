package com.bautista.backend.shared;

public enum Const {
    TIPO_MOVIMIENTO_INGRESO("ingreso"),
    TIPO_MOVIMIENTO_GASTO("gasto"),
    TIPO_MOVIMIENTO_TRANSFERENCIA("transferencia"),
    DESTINO_MOVIMIENTO_CAJA("caja"),
    DESTINO_MOVIMIENTO_BANCO("banco");

    private final String string;

    Const(String string){
        this.string = string;
    }
}
