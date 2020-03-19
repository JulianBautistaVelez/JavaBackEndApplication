package com.bautista.backend.model.tela;



public class TelaResponseModel {
    private String nombre;
    private float precioProveedor;
    private float precioCliente;
    private String tipo;
    private String comentarios;
    private String proveedor;
    private String telaId;

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

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getTelaId() {
        return telaId;
    }

    public void setTelaId(String telaId) {
        this.telaId = telaId;
    }
}
