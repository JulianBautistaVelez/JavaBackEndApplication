package com.bautista.backend.model.movimiento;

import com.bautista.backend.data.movimiento.DestinoMovimiento;
import com.bautista.backend.data.movimiento.TipoMovimiento;

import java.util.Date;

public class MovimientoResponseModel {

    private String concepto;
    private TipoMovimiento tipo;
    private Float valor;
    private DestinoMovimiento cajaBanco;
    private Date fecha;
    private String movimientoId;

    public String getMovimientoId() {
        return movimientoId;
    }

    public void setMovimientoId(String movimientoId) {
        this.movimientoId = movimientoId;
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

    public DestinoMovimiento getCajaBanco() {
        return cajaBanco;
    }

    public void setCajaBanco(DestinoMovimiento cajaBanco) {
        this.cajaBanco = cajaBanco;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
