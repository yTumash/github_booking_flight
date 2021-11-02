package com.solvd.flightbooking.interfaces;

public interface Bookable {

    void bookFlight();

    void bookSeat(Integer flightNum);

    Double calculatePrice();
}
