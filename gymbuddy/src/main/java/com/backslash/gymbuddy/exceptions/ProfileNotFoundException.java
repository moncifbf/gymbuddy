package com.backslash.gymbuddy.exceptions;

public class ProfileNotFoundException extends RuntimeException {

    public ProfileNotFoundException() {
        super("Profile not found.");
    }
}
