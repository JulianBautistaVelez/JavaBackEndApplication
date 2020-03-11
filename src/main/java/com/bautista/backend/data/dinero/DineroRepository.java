package com.bautista.backend.data.dinero;

import com.bautista.backend.data.dinero.DineroEntity;
import org.springframework.data.repository.CrudRepository;

public interface DineroRepository extends CrudRepository<DineroEntity, Long> {


    DineroEntity findTopByOrderByIdDesc();
}
