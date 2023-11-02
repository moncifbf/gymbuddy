package com.backslash.gymbuddy.dto.request;

import com.backslash.gymbuddy.model.GymContactInfo;
import com.backslash.gymbuddy.model.Pricing;

import java.util.List;

public record GymAddDTO(String name, String address, GymContactInfo gymContactInfo, String openingHours,
                        Pricing pricing, String rating, List<String> socialMediaLinks) {
}
