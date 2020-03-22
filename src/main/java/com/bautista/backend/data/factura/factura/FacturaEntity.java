package com.bautista.backend.data.factura.factura;

import com.bautista.backend.data.factura.fila.FilaFacturaEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "facturas")
public class FacturaEntity implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private String numeroIdentificador;

    @Column
    private String nombre;

    @Column
    private String nif;

    @Column
    private String direccion;

    @Column
    private String cpProvincia;

    @Column
    private float base;

    @Column
    private float iva;

    @Column
    private float total;

    @Column
    private String facturaId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "facturaReferenciaId", nullable = false)
    private List<FilaFacturaEntity> filas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNumeroIdentificador() {
        return numeroIdentificador;
    }

    public void setNumeroIdentificador(String numeroIdentificador) {
        this.numeroIdentificador = numeroIdentificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCpProvincia() {
        return cpProvincia;
    }

    public void setCpProvincia(String cpProvincia) {
        this.cpProvincia = cpProvincia;
    }

    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) { this.iva = iva; }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(String facturaId) {
        this.facturaId = facturaId;
    }

    public List<FilaFacturaEntity> getFilas() {
        return filas;
    }

    public void setFilas(List<FilaFacturaEntity> filas) {
        this.filas = filas;
    }

}
