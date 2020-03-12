package com.bautista.backend.data.movimiento;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name= "movimientos")
public class MovimientoEntity implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String concepto;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoMovimiento tipo;

    @Column(nullable = false)
    private Float valor;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DestinoMovimiento caja_banco;

    @Column
    @CreationTimestamp
    private Date fecha;

    @Column
    private String movimiento_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getMovimiento_id() { return movimiento_id; }

    public void setMovimiento_id(String movimiento_id) { this.movimiento_id = movimiento_id; }
}
