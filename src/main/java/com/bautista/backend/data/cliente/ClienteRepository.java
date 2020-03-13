package com.bautista.backend.data.cliente;

import com.bautista.backend.data.dinero.DineroEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClienteRepository extends CrudRepository<ClienteEntity, Long> {

    List<ClienteEntity> findAllBy();
    ClienteEntity findTopByOrderByIdDesc();
}
