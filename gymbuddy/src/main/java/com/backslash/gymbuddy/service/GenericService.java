package com.backslash.gymbuddy.service;

import java.util.List;

public interface GenericService<R, I> {
    R create(R entity);

    R update(R entity);

    R getOne(I entityId);

    List<R> getAll();

    Boolean delete(I entityId);
}
