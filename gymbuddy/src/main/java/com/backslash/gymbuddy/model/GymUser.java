package com.backslash.gymbuddy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "GYM_USER")
public class GymUser extends AppUser {
    @Column(name = "AGE")
    private int age;
    @ManyToOne
    private Gym currentGym;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "GYM_USER_GYM_BUDDY",
            joinColumns = @JoinColumn(name = "gym_user_id"),
            inverseJoinColumns = @JoinColumn(name = "gym_buddy_id")
    )
    @JsonIgnore
    private List<GymUser> gymBuddies;
}
