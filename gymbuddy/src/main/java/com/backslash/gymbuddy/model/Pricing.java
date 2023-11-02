package com.backslash.gymbuddy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PRICING")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Pricing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Double monthly;
    private Double yearly;
    private String currency;
}
