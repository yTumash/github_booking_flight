package com.reservation.flightbooking;

import java.util.List;
public interface Bookable {

    void bookFlight();

    void bookSeat(Integer flightNum);

    Double calculatePrice();
}
