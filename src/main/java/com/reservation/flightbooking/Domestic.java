package com.reservation.flightbooking;

import java.time.LocalDate;
import java.time.LocalTime;

public class Domestic extends Flight implements Flyable {

    public Domestic(LocalDate date, Integer flightNumber, LocalTime departureTime, LocalTime arrivalTime) {
        super(date, flightNumber, departureTime, arrivalTime);
    }

    @Override
    public void fly() {
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
