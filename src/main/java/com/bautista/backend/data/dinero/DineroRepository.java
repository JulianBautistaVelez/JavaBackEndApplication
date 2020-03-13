package com.bautista.backend.data.dinero;

import com.bautista.backend.data.dinero.DineroEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DineroRepository extends CrudRepository<DineroEntity, Long> {
    DineroEntity findTopByOrderByIdDesc();
    List<DineroEntity> findAllBy();
}
