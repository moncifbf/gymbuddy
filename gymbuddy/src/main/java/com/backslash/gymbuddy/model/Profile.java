package com.backslash.gymbuddy.model;

import com.backslash.gymbuddy.model.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "PROFILE")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private AppUser appUser;
    private String displayName;
    private Gender gender;
    private LocalDate birthday;
    @ElementCollection
    private List<String> fitnessGoals;
    @ElementCollection
    private List<String> workoutFrequency;
    private String currentLocation;
    @ElementCollection
    private List<String> socialMediaLinks;
}
