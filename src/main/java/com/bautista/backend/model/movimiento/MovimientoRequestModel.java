package com.bautista.backend.model.movimiento;

import com.bautista.backend.data.movimiento.DestinoMovimiento;
import com.bautista.backend.data.movimiento.TipoMovimiento;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class MovimientoRequestModel {

    private String concepto;
    @NotNull(message = "Es obligatorio introducir un tipo de movimiento: ingreso/gasto")
    private TipoMovimiento tipo;
    @NotNull(message = "Es obligatorio introducir un valor")
    private Float valor;
    @NotNull(message = "Es obligatorio introducir destino al movimiento: caja/banco")
    private DestinoMovimiento cajaBanco;
    private Date fecha;
    private String movimientoId;
    private Boolean deducible;
    private String descripcion;

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

    public String getMovimientoId() {
        return movimientoId;
    }

    public void setMovimientoId(String movimientoId) {
        this.movimientoId = movimientoId;
    }

    public Boolean getDeducible() { return deducible; }

    public void setDeducible(Boolean deducible) { this.deducible = deducible; }

    public String getDescripcion() { return descripcion; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
