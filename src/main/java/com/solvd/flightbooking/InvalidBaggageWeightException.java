package com.solvd.flightbooking;

public class InvalidBaggageWeightException extends RuntimeException {

    public InvalidBaggageWeightException(String message) {
        super(message);
    }

    public InvalidBaggageWeightException(String message, Throwable cause) {
        super(message, cause);
    }
}
