package com.bautista.backend.model.informacion.gastos;

public enum ConceptoGastos {
    comida("Comida"),
    combustible("Combustible"),
    salario("Salario"),
    alquilerTaller("Alquiler taller"),
    servicios("Servicios"),
    impuestos("Impuestos"),
    seguridadSocial("Seguridad social");

    private String value;

    ConceptoGastos(String value){
        this.value = value;
    }

    public String getValue(){ return value;}


}
