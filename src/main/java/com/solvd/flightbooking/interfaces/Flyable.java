package com.solvd.flightbooking.interfaces;

import com.solvd.flightbooking.Airport;

public interface Flyable {

    void flyFrom(Airport id);

    void flyTo(Airport id);

    void fly();
}
