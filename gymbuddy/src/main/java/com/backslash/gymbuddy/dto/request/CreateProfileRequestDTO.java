package com.backslash.gymbuddy.dto.request;

import com.backslash.gymbuddy.model.enums.Gender;

import java.time.LocalDate;
import java.util.List;

public record CreateProfileRequestDTO(Long userId, String displayName, Gender gender, LocalDate birthday,
                                      List<String> fitnessGoals, List<String> workoutFrequency, String currentLocation,
                                      List<String> socialMediaLinks) {
}
