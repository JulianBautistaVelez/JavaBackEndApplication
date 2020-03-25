package com.bautista.backend.data.tela;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "telas")
public class TelaEntity implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column
    @CreationTimestamp
    private Date fecha;

    @Column
    private String nombre;

    @Column
    private float precioProveedor;

    @Column
    private float precioCliente;

    @Column
    private String tipo;

    @Column
    private String proveedor;

    @Column
    private String comentarios;

    @Column
    private String telaId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecioProveedor() {
        return precioProveedor;
    }

    public void setPrecioProveedor(float precioProveedor) {
        this.precioProveedor = precioProveedor;
    }

    public float getPrecioCliente() {
        return precioCliente;
    }

    public void setPrecioCliente(float precioCliente) {
        this.precioCliente = precioCliente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getComentarios() { return comentarios; }

    public void setComentarios(String comentarios) { this.comentarios = comentarios; }

    public String getTelaId() {
        return telaId;
    }

    public void setTelaId(String telaId) {
        this.telaId = telaId;
    }
}
