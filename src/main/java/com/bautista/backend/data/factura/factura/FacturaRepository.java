package com.bautista.backend.data.factura.factura;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FacturaRepository extends CrudRepository<FacturaEntity, Long> {
    FacturaEntity findTopByOrderByFechaDesc();
    List<FacturaEntity> findAllBy();
    FacturaEntity findByFacturaId(String facturaId);
}
