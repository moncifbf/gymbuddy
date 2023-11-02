package com.backslash.gymbuddy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "GYM_CONTACT_INFO")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GymContactInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String phone;
    private String email;
}
