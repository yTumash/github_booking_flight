package com.solvd.flightbooking.exceptions;

public class InvalidCarryOnWeightException extends RuntimeException{

    public InvalidCarryOnWeightException(String message) {
        super(message);
    }

    public InvalidCarryOnWeightException(String message, Throwable cause) {
        super(message, cause);
    }
}
