package com.bautista.backend.data.movimiento;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface MovimientoRepository extends CrudRepository<MovimientoEntity, Long> {

    List<MovimientoEntity> findAllBy();
    MovimientoEntity findAllByOrderByFechaDesc();
    MovimientoEntity findTopByOrderByFechaDesc();
    MovimientoEntity findByMovimientoId(String id);

    @Query(value = "SELECT * FROM movimientos WHERE tipo= :tipo_movimiento " +
            "AND fecha BETWEEN :fecha_inicio AND :fecha_fin ORDER BY fecha DESC",
            nativeQuery = true)
    List<MovimientoEntity> findMovimientosROT(
            @Param("fecha_inicio") Date fechaInicio,
            @Param("fecha_fin") Date fechaFin,
            @Param("tipo_movimiento") String tipoMovimiento);

    @Query(value = "SELECT * FROM movimientos WHERE " +
            "fecha BETWEEN :fecha_inicio AND :fecha_fin ORDER BY fecha DESC",
            nativeQuery = true)
    List<MovimientoEntity> findROT(
            @Param("fecha_inicio") Date fechaInicio,
            @Param("fecha_fin") Date fechaFin);

}
