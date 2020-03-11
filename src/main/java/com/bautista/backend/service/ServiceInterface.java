package com.bautista.backend.service;

import com.bautista.backend.model.dinero.DineroResponseModel;

public interface ServiceInterface<T> {
    T getLastEntry();
    T getAll();
}
