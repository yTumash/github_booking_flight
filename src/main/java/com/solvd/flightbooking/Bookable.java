package com.solvd.flightbooking;

public interface Bookable {

    void bookFlight();

    void bookSeat(Integer flightNum);

    Double calculatePrice();
}
