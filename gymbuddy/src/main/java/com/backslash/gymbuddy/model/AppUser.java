package com.backslash.gymbuddy.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "APP_USER")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private long id;
    private String username;
    private String password;
    private String email;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST) //TODO change cascade type later
    @JoinTable(name = "APP_USER_AUTHORITIES",
            joinColumns = @JoinColumn(name = "appUserId"),
            inverseJoinColumns = @JoinColumn(name = "authorityId")
    )
    private Set<Authority> authorities;
    @OneToOne(mappedBy = "appUser", cascade = CascadeType.PERSIST)
    private Profile profile;
}
