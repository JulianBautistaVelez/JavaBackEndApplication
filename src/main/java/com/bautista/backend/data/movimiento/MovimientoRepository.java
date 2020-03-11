package com.bautista.backend.data.movimiento;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovimientoRepository extends CrudRepository<MovimientoEntity, Long> {

    List<MovimientoEntity> findAllBy();
    MovimientoEntity findAllByOrderByFechaDesc();
    MovimientoEntity findTopByOrderByFechaDesc();

}
