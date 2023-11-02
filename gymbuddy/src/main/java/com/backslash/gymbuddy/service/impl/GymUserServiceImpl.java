package com.backslash.gymbuddy.service.impl;

import com.backslash.gymbuddy.dto.request.LinkGymBuddyDTO;
import com.backslash.gymbuddy.dto.request.LinkGymDTO;
import com.backslash.gymbuddy.exceptions.AppUserNotFoundException;
import com.backslash.gymbuddy.exceptions.GymNotFoundException;
import com.backslash.gymbuddy.model.Gym;
import com.backslash.gymbuddy.model.GymUser;
import com.backslash.gymbuddy.repository.GymUserRepository;
import com.backslash.gymbuddy.service.GymService;
import com.backslash.gymbuddy.service.GymUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Component
public class GymUserServiceImpl implements GymUserService {

    private final GymUserRepository gymUserRepository;
    private final GymService gymService;

    @Transactional
    @Override
    public GymUser create(GymUser entity) {
        return gymUserRepository.save(entity);
    }

    @Override
    public GymUser update(GymUser entity) {
        return null;
    }

    @Override
    public GymUser getOne(Long entityId) {
        return gymUserRepository.findById(entityId).orElseThrow(AppUserNotFoundException::new);
    }

    @Override
    public List<GymUser> getAll() {
        return gymUserRepository.findAll();
    }

    @Override
    public Boolean delete(Long entityId) {
        return null;
    }

    @Transactional
    @Override
    public GymUser linkGymBuddies(LinkGymBuddyDTO request) {
        GymUser gymUser = getOne(request.id());
        if (isNull(gymUser)) {
            throw new AppUserNotFoundException();
        }
        List<Long> gymBuddiesIds = request.gymBuddiesIds();
        List<GymUser> gymBuddies = gymBuddiesIds.stream().map(this::getOne).collect(Collectors.toList());
        gymBuddies.forEach(gymBuddy -> gymBuddy.getGymBuddies().add(gymUser));
        gymUser.setGymBuddies(gymBuddies);
        return gymUserRepository.save(gymUser);
    }

    @Transactional
    @Override
    public GymUser linkGym(LinkGymDTO linkGymDTO) {
        GymUser gymUser = getOne(linkGymDTO.id());
        if (isNull(gymUser)) {
            throw new AppUserNotFoundException();
        }

        Gym gym = gymService.getOne(linkGymDTO.gymId());
        if (isNull(gym)) {
            throw new GymNotFoundException();
        }

        gymUser.setCurrentGym(gym);
        return gymUserRepository.save(gymUser);
    }
}
