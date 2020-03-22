package com.bautista.backend.service;


import com.bautista.backend.model.shared.RangeOfTimeRequest;
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
    List<T> getAllROT(RangeOfTimeRequest request);
    void insert(T2 requestModel);
    T findById(String id);
    void update(T2 requestModel, String id);
    void delete(String id);

}
