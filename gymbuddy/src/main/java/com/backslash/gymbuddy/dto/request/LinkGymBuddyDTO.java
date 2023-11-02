package com.backslash.gymbuddy.dto.request;

import java.util.List;

public record LinkGymBuddyDTO(Long id, List<Long> gymBuddiesIds) {
}
