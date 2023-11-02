package com.backslash.gymbuddy.service;

import com.backslash.gymbuddy.dto.request.CreateProfileRequestDTO;
import com.backslash.gymbuddy.dto.response.ProfileResponseDTO;
import com.backslash.gymbuddy.model.Profile;
import org.springframework.stereotype.Service;

@Service
public interface ProfileService extends GenericService<Profile, Long> {
    ProfileResponseDTO linkProfile(CreateProfileRequestDTO dto);
    ProfileResponseDTO getProfileById(Long id);
}
