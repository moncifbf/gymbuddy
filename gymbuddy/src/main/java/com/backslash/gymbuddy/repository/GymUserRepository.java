package com.backslash.gymbuddy.repository;

import com.backslash.gymbuddy.model.GymUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymUserRepository extends JpaRepository<GymUser, Long> {
}
