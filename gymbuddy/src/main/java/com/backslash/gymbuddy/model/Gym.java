package com.backslash.gymbuddy.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "GYM")
public class Gym {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "GYM_CONTACT_INFO")
    private GymContactInfo gymContactInfo;
    private String openingHours;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PRICING")
    private Pricing pricing;
    private String rating;
    @ElementCollection
    private List<String> socialMediaLinks;
}
