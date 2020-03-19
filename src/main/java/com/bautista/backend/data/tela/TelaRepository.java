package com.bautista.backend.data.tela;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TelaRepository extends CrudRepository<TelaEntity, Long> {

    TelaEntity findByTelaId(String id);
    List<TelaEntity> findAllBy();
    TelaEntity findTopByOrderByIdDesc();
    List<TelaEntity> findByNombre(String nombre);

    @Query(value = "SELECT * FROM telas WHERE " +
            "precio BETWEEN :precio_min AND :precio_max",
            nativeQuery = true)
    List<TelaEntity> findRangeOfPrice(
            @Param("precio_min") float precioMin,
            @Param("precio_max") float precioMax);
}
