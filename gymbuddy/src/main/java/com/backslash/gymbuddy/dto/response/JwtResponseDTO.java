package com.backslash.gymbuddy.dto.response;

import java.util.List;

public record JwtResponseDTO(String token, String type, String username, List<String> roles) {
}
