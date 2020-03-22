package com.bautista.backend.data.factura.fila;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "filas_facturas")
public class FilaFacturaEntity implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private int facturaReferenciaId;

    @Column
    private String concepto;

    @Column
    private Float valor;

    @Column
    private int unidades;

    @Column
    private float valorTotal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFacturaReferenciaId() {
        return facturaReferenciaId;
    }

    public void setFacturaReferenciaId(int facturaReferenciaId) {
        this.facturaReferenciaId = facturaReferenciaId;
    }

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

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

}
