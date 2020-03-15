package com.bautista.backend.data.dinero;

import com.bautista.backend.data.dinero.DineroEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface DineroRepository extends CrudRepository<DineroEntity, Long> {
    DineroEntity findTopByOrderByIdDesc();
    List<DineroEntity> findAllBy();

    @Query( value = "SELECT * FROM dinero WHERE fecha IN (SELECT MAX(fecha) FROM dinero " +
                    "GROUP BY CAST(fecha AS DATE)) " +
                    "ORDER BY fecha ASC",
            nativeQuery = true)
    List<DineroEntity> findEndOfDay();

    @Query(value = "SELECT * FROM dinero WHERE fecha IN (SELECT MAX(fecha) " +
                    "FROM dinero GROUP BY CAST(fecha AS DATE)) " +
                    "AND fecha BETWEEN :fecha_inicio AND :fecha_fin "+
                    "ORDER BY fecha ASC",
            nativeQuery = true)
    List<DineroEntity> findRangeOfTime(
            @Param("fecha_inicio") Date fechaInicio,
            @Param("fecha_fin") Date fechaFin);

}
