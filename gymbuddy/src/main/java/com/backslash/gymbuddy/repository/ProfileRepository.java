package com.backslash.gymbuddy.repository;

import com.backslash.gymbuddy.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
