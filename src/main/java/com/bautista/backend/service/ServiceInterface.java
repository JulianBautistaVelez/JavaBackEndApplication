package com.bautista.backend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.util.List;

/**
 * Service so serve as middle step from controller to data
 * Map from entities to response or request objects models
 * and the opposite
 * @param <T> Object Response Model
 * @param <T2> Object Request Model
 */
public interface ServiceInterface<T, T2> {

    T getLastEntry();
    List<T> getAll();
    void insert(T2 object);
    T findById(String id);
}
