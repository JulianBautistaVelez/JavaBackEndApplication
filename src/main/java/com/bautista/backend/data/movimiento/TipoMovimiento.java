package com.bautista.backend.data.movimiento;

public enum TipoMovimiento {
    ingreso,
    gasto,
    transferencia;

    @Override
    public String toString() {
        if(this.equals(TipoMovimiento.ingreso)){ return "ingreso";}
        if(this.equals(TipoMovimiento.gasto)){ return "gasto";}
        if(this.equals(TipoMovimiento.transferencia)){ return "transferencia";}
        return "";
    }
}
