package com.bautista.backend.data.resumen;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="resumenes")
public class ResumenEntity implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private int anyo;

    @Column(nullable = false)
    private int mes;

    @Column(nullable = false)
    private float gastos;

    @Column(nullable = false)
    private float ingresos;

    @Column(nullable = false)
    private float resultado;

    @Column(nullable = false)
    private float flujoCaja;

    @Column(nullable = false)
    private float facturado;

    @Column(nullable = false)
    private float deducible;

}
