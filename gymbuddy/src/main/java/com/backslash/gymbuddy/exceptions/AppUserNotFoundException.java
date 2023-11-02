package com.backslash.gymbuddy.exceptions;

public class AppUserNotFoundException extends RuntimeException {
    public AppUserNotFoundException() {
        super("User not found.");
    }
}
