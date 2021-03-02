package com.bautista.backend.data.movimiento;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/*TODO pensar en añadir un "estadoMovimiento" que almacene si el movimiento ha sido borrado
    Para mantener un record de los movimientos aunque hayan sido eliminados, y luego enviarlos
    a front end o no dependiendo de la situacion
*/
@Entity
@Table(name= "movimientos")
public class MovimientoEntity implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String concepto;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoMovimiento tipo;

    @Column(nullable = false)
    private Float valor;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DestinoMovimiento cajaBanco;

    @Column
    @CreationTimestamp
    private Date fecha;

    @Column
    private String movimientoId;

    @Column(columnDefinition = "boolean default false")
    private Boolean deducible;

    @Column
    private String descripcion;

    public MovimientoEntity copy(){
        MovimientoEntity response = new MovimientoEntity();
        response.setConcepto(this.getConcepto());
        response.setTipo(this.getTipo());
        response.setValor(this.getValor());
        response.setDeducible(this.getDeducible());
        response.setDescripcion(this.getDescripcion());
        return response;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public TipoMovimiento getTipo() {
        return tipo;
    }

    public void setTipo(TipoMovimiento tipo) {
        this.tipo = tipo;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public DestinoMovimiento getCajaBanco() {
        return cajaBanco;
    }

    public void setCajaBanco(DestinoMovimiento cajaBanco) {
        this.cajaBanco = cajaBanco;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMovimientoId() { return movimientoId; }

    public void setMovimientoId(String movimientoId) { this.movimientoId = movimientoId; }

    public Boolean getDeducible() {return deducible;}

    public void setDeducible(Boolean deducible) {this.deducible = deducible;}

    public String getDescripcion() {return descripcion;}

    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
}
