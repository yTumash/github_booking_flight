package com.reservation.flightbooking;

public class InvalidAgeException extends RuntimeException {

    public InvalidAgeException(String message) {
        super(message);
    }

    public InvalidAgeException(String message, Throwable cause) {
        super(message, cause);
    }
}
