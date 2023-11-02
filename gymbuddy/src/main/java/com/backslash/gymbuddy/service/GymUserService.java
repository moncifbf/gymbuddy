package com.backslash.gymbuddy.service;

import com.backslash.gymbuddy.dto.request.LinkGymBuddyDTO;
import com.backslash.gymbuddy.dto.request.LinkGymDTO;
import com.backslash.gymbuddy.model.GymUser;
import org.springframework.stereotype.Service;

@Service
public interface GymUserService extends GenericService<GymUser, Long> {
    GymUser linkGymBuddies(LinkGymBuddyDTO linkGymBuddyDTO);

    GymUser linkGym(LinkGymDTO linkGymDTO);
}
