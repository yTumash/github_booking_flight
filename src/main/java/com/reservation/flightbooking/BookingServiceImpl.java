package com.reservation.flightbooking;

import java.util.Objects;

public class BookingServiceImpl implements BookingService {

    private Integer flightNum;

    public Integer getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(Integer flightNum) {
        this.flightNum = flightNum;
    }

    @Override
    public void bookSmth(Bookable bookable) {
        bookable.bookFlight();
        bookable.bookSeat(flightNum);
        bookable.calculatePrice();
    }

    @Override
    public String toString() {
        return
                "Flight: " +
                        "Flight Number: " + getFlightNum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookingServiceImpl)) return false;
        BookingServiceImpl that = (BookingServiceImpl) o;
        return Objects.equals(flightNum, that.flightNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightNum);
    }
}
