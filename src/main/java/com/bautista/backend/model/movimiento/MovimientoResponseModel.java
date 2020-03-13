package com.bautista.backend.model.movimiento;

import com.bautista.backend.data.movimiento.DestinoMovimiento;
import com.bautista.backend.data.movimiento.TipoMovimiento;

import java.util.Date;

public class MovimientoResponseModel {

    private String concepto;
    private TipoMovimiento tipo;
    private Float valor;
    private DestinoMovimiento caja_banco;
    private Date fecha;
    private String movimiento_id;

    public String getMovimiento_id() {
        return movimiento_id;
    }

    public void setMovimiento_id(String movimientoId) {
        this.movimiento_id = movimientoId;
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
