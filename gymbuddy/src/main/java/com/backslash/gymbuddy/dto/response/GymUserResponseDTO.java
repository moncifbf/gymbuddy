package com.backslash.gymbuddy.dto.response;

import com.backslash.gymbuddy.model.Gym;

public record GymUserResponseDTO(String username, String password, String email, Gym currentGym) {
}
