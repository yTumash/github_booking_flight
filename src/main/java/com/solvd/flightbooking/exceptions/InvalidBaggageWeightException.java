package com.solvd.flightbooking.exceptions;

public class InvalidBaggageWeightException extends RuntimeException {

    public InvalidBaggageWeightException(String message) {
        super(message);
    }

    public InvalidBaggageWeightException(String message, Throwable cause) {
        super(message, cause);
    }
}
