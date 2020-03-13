package com.bautista.backend.model.cliente;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class ClienteRequestModel {

    @NotNull(message = "Es obligatorio introducir un nombre para el cliente")
    private String nombre;
    private String direccion;
    private int telefono;
    private String trabajos;
    private String presupuestos;
    private String comentarios;
    private Date fecha;

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

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
