package com.temporintech.animalhaven.services;

import java.util.List;
import java.util.UUID;

public interface CrudService<T, D> {

    T save(D dto);

    T update(UUID id, D dto);

    List<T> findAll();

    T findById(UUID id);

    void delete(UUID id);
}
