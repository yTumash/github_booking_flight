package com.solvd.flightbooking.exceptions;

public class InvalidHumanNameException extends Exception{

    public InvalidHumanNameException(String message) {
        super(message);
    }

    public InvalidHumanNameException(String message, Throwable cause) {
        super(message, cause);
    }
}
