package com.reservation.flightbooking;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Ticket {

    private static final Logger LOGGER = LogManager.getLogger(Ticket.class);

    private Flight<Passenger> flight;
    private Passenger passenger;
    private Itinerary itinerary;
    private Double price;
    private int number;

    public Flight<Passenger> getFlight() {
        return flight;
    }

    public void setFlight(Flight<Passenger> flight) {
        this.flight = flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Itinerary getItinerary() {
        return itinerary;
    }

    public void setItinerary(Itinerary itinerary) {
        this.itinerary = itinerary;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = flight.calculatePrice();
    }

    @Override
    public String toString() {
        return "Passenger's name: " + passenger.getName() + "\n" +
                "Departs from: " + Itinerary.getOrig() + "\n" +
                "Arrives at: " + Itinerary.getDest() + "\n" +
                "Departs at: " + flight.getDepartureTime() + "\n" +
                "Initial price: " + flight.getPrice() + "\n" +
                "Ticket price: " + passenger.useDiscount(flight) + "\n";
    }

    public void printData(){
        String a = toString();
        LOGGER.debug(a);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;
        Ticket ticket = (Ticket) o;
        return number == ticket.number && Objects.equals(flight, ticket.flight) && Objects.equals(passenger, ticket.passenger) && Objects.equals(itinerary, ticket.itinerary) && Objects.equals(price, ticket.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flight, passenger, itinerary, price, number);
    }
}
