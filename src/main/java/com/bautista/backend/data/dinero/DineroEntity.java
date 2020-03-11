package com.bautista.backend.data.dinero;

/**
 * @author Julián Bautista Vélez
 */

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
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

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
}
