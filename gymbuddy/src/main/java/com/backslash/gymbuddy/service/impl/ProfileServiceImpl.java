package com.backslash.gymbuddy.service.impl;

import com.backslash.gymbuddy.dto.request.CreateProfileRequestDTO;
import com.backslash.gymbuddy.dto.response.ProfileResponseDTO;
import com.backslash.gymbuddy.exceptions.AppUserNotFoundException;
import com.backslash.gymbuddy.exceptions.ProfileNotFoundException;
import com.backslash.gymbuddy.model.AppUser;
import com.backslash.gymbuddy.model.Profile;
import com.backslash.gymbuddy.repository.AppUserRepository;
import com.backslash.gymbuddy.repository.ProfileRepository;
import com.backslash.gymbuddy.service.AppUserService;
import com.backslash.gymbuddy.service.ProfileService;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Objects.isNull;

@Component
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;
    private final AppUserService appUserService;
    private final AppUserRepository appUserRepository;

    @Transactional
    @Override
    public Profile create(Profile entity) {
        return profileRepository.save(entity);
    }

    @Transactional
    @Override
    public Profile update(Profile entity) {
        return null;
    }

    @Override
    public Profile getOne(Long entityId) {
        return null;
    }

    public ProfileResponseDTO getProfileById(Long entityId) {
        Profile dbProfile = profileRepository.findById(entityId).orElseThrow(ProfileNotFoundException::new);
        return new ProfileResponseDTO(dbProfile.getId(), dbProfile.getAppUser().getUsername(), dbProfile.getAppUser().getEmail(), dbProfile.getDisplayName(), dbProfile.getGender(), dbProfile.getBirthday(), dbProfile.getFitnessGoals(), dbProfile.getWorkoutFrequency(), dbProfile.getCurrentLocation(), dbProfile.getSocialMediaLinks());
    }

    @Override
    public List<Profile> getAll() {
        return Collections.emptyList();
    }

    @Override
    public Boolean delete(Long entityId) {
        return null;
    }

    @Transactional
    @Override
    public ProfileResponseDTO linkProfile(CreateProfileRequestDTO dto) {
        AppUser appUser = appUserService.getOne(dto.userId());
        if (!isNull(appUser)) {
            Profile createdProfile = createProfile(dto, appUser);
            appUser.setProfile(createdProfile);
            profileRepository.saveAndFlush(createdProfile);
            appUserRepository.saveAndFlush(appUser);
            return new ProfileResponseDTO(createdProfile.getId(), appUser.getUsername(), appUser.getEmail(), createdProfile.getDisplayName(), createdProfile.getGender(), createdProfile.getBirthday(), createdProfile.getFitnessGoals(), createdProfile.getWorkoutFrequency(), createdProfile.getCurrentLocation(), createdProfile.getSocialMediaLinks());
        } else {
            throw new AppUserNotFoundException();
        }
    }

    private static Profile createProfile(CreateProfileRequestDTO dto, AppUser appUser) {
        Profile createdProfile = new Profile();
        createdProfile.setAppUser(appUser);
        createdProfile.setBirthday(dto.birthday());
        createdProfile.setGender(dto.gender());
        createdProfile.setFitnessGoals(dto.fitnessGoals());
        createdProfile.setCurrentLocation(dto.currentLocation());
        createdProfile.setSocialMediaLinks(dto.socialMediaLinks());
        createdProfile.setWorkoutFrequency(dto.workoutFrequency());
        createdProfile.setDisplayName(dto.displayName());
        return createdProfile;
    }
}
