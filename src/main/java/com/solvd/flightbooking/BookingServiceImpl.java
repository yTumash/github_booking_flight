package com.solvd.flightbooking;

import com.solvd.flightbooking.interfaces.Bookable;
import com.solvd.flightbooking.interfaces.BookingService;
import com.solvd.flightbooking.interfaces.Buyable;

import java.util.Objects;
import java.util.Optional;

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

    public void buy(Buyable buyATicket){
       buyATicket.buy();
    }

    public Optional<String> compareValue(Flight<Passenger> flight){
        String result = null;
        if(flight.getPrice() > flight.calculatePrice()){
            result = "There is an agreeable discount";
        }
        return Optional.ofNullable(result);
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
