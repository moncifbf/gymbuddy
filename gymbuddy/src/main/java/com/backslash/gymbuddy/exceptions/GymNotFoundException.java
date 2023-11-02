package com.backslash.gymbuddy.exceptions;

public class GymNotFoundException extends RuntimeException {
    public GymNotFoundException() {
        super("Gym not found.");
    }
}
