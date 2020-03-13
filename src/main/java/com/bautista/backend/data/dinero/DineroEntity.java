package com.bautista.backend.data.dinero;

/**
 * @author Julián Bautista Vélez
 */

import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="dinero")
public class DineroEntity implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private float banco;

    @Column(nullable = false)
    private float caja;

    @Column
    @CreationTimestamp
    private Date fecha;

    @Column
    private String dinero_id;

    public float getBanco() {
        return banco;
    }

    public void setBanco(float banco) {
        this.banco = banco;
    }

    public float getCaja() {
        return caja;
    }

    public void setCaja(float caja) {
        this.caja = caja;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getDinero_id() { return dinero_id; }

    public void setDinero_id(String dinero_id) { this.dinero_id = dinero_id; }
}
