package com.bautista.backend.data.factura.factura;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface FacturaRepository extends CrudRepository<FacturaEntity, Long> {
    FacturaEntity findTopByOrderByFechaDesc();
    List<FacturaEntity> findAllBy();
    FacturaEntity findByFacturaId(String facturaId);

    @Query(value = "SELECT * FROM facturas WHERE " +
            "fecha BETWEEN :fecha_inicio AND :fecha_fin",
            nativeQuery = true)
    List<FacturaEntity> findAllROTBy(
            @Param("fecha_inicio") Date fechaInicio,
            @Param("fecha_fin") Date fechaFin);
}
