package com.bautista.backend.model.factura.factura;

import com.bautista.backend.model.factura.fila.FilaResponseModel;

import java.util.Date;
import java.util.List;

public class FacturaResponseModel {

    private Date fecha;
    private String numeroIdentificador;
    private String nombre;
    private String nif;
    private String direccion;
    private String cpProvincia;
    private float base;
    private float iva;
    private List<FilaResponseModel> filas;
    private String facturaId;

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

    public void setIva(float iva) {
        this.iva = iva;
    }

    public List<FilaResponseModel> getFilas() {
        return filas;
    }

    public void setFilas(List<FilaResponseModel> filas) {
        this.filas = filas;
    }

    public String getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(String facturaId) {
        this.facturaId = facturaId;
    }
}
