package com.bautista.backend.model.factura.factura;

import com.bautista.backend.model.factura.fila.FilaRequestModel;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class FacturaRequestModel {

    @NotNull(message = "Es obligatorio introducir una fecha")
    private Date fecha;

    @NotNull(message = "Es obligatorio introducir un número de identificación")
    private String numeroIdentificador;

    private String nombre;
    private String nif;
    private String direccion;
    private String cpProvincia;
    private List<FilaRequestModel> filas;

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

    public List<FilaRequestModel> getFilas() {
        return filas;
    }

    public void setFilas(List<FilaRequestModel> filas) {
        this.filas = filas;
    }
}
