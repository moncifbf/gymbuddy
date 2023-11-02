package com.backslash.gymbuddy.service.impl;

import com.backslash.gymbuddy.exceptions.GymNotFoundException;
import com.backslash.gymbuddy.model.Gym;
import com.backslash.gymbuddy.repository.GymRepository;
import com.backslash.gymbuddy.service.GymService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Component
public class GymServiceImpl implements GymService {

    private final GymRepository gymRepository;

    @Transactional
    @Override
    public Gym create(Gym entity) {
        return gymRepository.save(entity);
    }

    @Override
    public Gym update(Gym entity) {
        return null;
    }

    @Override
    public Gym getOne(Long entityId) {
        return gymRepository.findById(entityId).orElseThrow(GymNotFoundException::new);
    }

    @Override
    public List<Gym> getAll() {
        return gymRepository.findAll();
    }

    @Override
    public Boolean delete(Long entityId) {
        return null;
    }
}
