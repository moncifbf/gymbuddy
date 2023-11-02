package com.backslash.gymbuddy.repository;

import com.backslash.gymbuddy.model.Gym;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymRepository extends JpaRepository<Gym, Long> {
}
