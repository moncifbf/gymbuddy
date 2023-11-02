package com.backslash.gymbuddy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "AUTHORITY")
@Getter
@Setter
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @ManyToMany(mappedBy = "authorities", cascade = CascadeType.PERSIST) //TODO change cascade type after
    @JsonIgnore
    private Set<AppUser> users;
}
