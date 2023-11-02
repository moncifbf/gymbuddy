package com.backslash.gymbuddy.dto.response;

import com.backslash.gymbuddy.model.enums.Gender;

import java.time.LocalDate;
import java.util.List;

public record ProfileResponseDTO(Long id, String username, String email, String displayName, Gender gender, LocalDate birthday,
                                 List<String> fitnessGoals, List<String> workoutFrequency, String currentLocation,
                                 List<String> socialMediaLinks) {
}
