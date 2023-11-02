package com.backslash.gymbuddy.service.impl;

import com.backslash.gymbuddy.exceptions.AppUserNotFoundException;
import com.backslash.gymbuddy.model.AppUser;
import com.backslash.gymbuddy.repository.AppUserRepository;
import com.backslash.gymbuddy.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Component
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;

    @Override
    public AppUser create(AppUser entity) {
        return appUserRepository.save(entity);
    }

    @Override
    public AppUser update(AppUser entity) {
        return null;
    }

    @Override
    public AppUser getOne(Long entityId) {
        return appUserRepository.findById(entityId).orElseThrow(AppUserNotFoundException::new);
    }

    @Override
    public List<AppUser> getAll() {
        return appUserRepository.findAll();
    }

    @Override
    public Boolean delete(Long entityId) {
        return null;
    }
}
