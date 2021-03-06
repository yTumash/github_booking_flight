package com.solvd.flightbooking;

import com.solvd.flightbooking.interfaces.Flyable;

import java.time.LocalDate;
import java.time.LocalTime;

public class International extends Flight<Passenger> implements Flyable {

    public International(LocalDate date, Integer flightNumber, LocalTime departureTime, LocalTime arrivalTime) {
        super(date, flightNumber, departureTime, arrivalTime);
    }

    @Override
    public void fly() {
    }

}
