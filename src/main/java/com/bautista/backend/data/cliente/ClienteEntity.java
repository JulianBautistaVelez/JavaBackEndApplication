package com.bautista.backend.data.cliente;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "clientes")
public class ClienteEntity implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String nombre;

    @Column
    private String direccion;

    @Column
    private int telefono;

    @Column
    private String trabajos;

    @Column
    private String presupuestos;

    @Column
    private String comentarios;

    @Column
    @CreationTimestamp
    private Date fecha;

    @Column
    private String clienteId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getTrabajos() {
        return trabajos;
    }

    public void setTrabajos(String trabajos) {
        this.trabajos = trabajos;
    }

    public String getPresupuestos() {
        return presupuestos;
    }

    public void setPresupuestos(String presupuestos) {
        this.presupuestos = presupuestos;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) { this.comentarios = comentarios; }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getClienteId() { return clienteId; }

    public void setClienteId(String clienteId) { this.clienteId = clienteId; }
}
