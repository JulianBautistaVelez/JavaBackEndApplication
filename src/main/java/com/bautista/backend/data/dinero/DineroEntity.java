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
    private String dineroId;

    public DineroEntity copy(){
        DineroEntity response = new DineroEntity();
        response.setCaja(this.getCaja());
        response.setBanco(this.getBanco());
        return response;
    }

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

    public String getDineroId() { return dineroId; }

    public void setDineroId(String dineroId) { this.dineroId = dineroId; }
}
