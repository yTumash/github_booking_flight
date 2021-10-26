package com.solvd.flightbooking;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalTime;
import java.util.*;

public class Airport<AirlineCompany> {

    private static final Logger LOGGER = LogManager.getLogger(Airport.class);

    private String id;
    private String name;
    private List<Flight<Passenger>> flights;
    private List<AirlineCompany> airlines;

    public Airport(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws InvalidNameException {
        char c;
        for (int i = 0; i < id.length(); i++) {
            c = id.charAt(i);
            if (Character.isLowerCase(c) && Character.isDigit(c)) {
                throw new InvalidNameException("The id should only contain capital letters");
            }
            this.id = id;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Flight<Passenger>> getFlight() {
        return flights;
    }

    public void setFlight(List<Flight<Passenger>> flights) {
        this.flights = flights;
    }

    public void setAirlines(List<AirlineCompany> airlines) {
        this.airlines = airlines;
    }

    public List<AirlineCompany> getAirlines() {
        return airlines;
    }

    public void receivePlane(Flight<Passenger> flight) {
        if (LocalTime.now() == flight.getDepartureTime()) {
            LOGGER.debug(flight.getFlightNumber() + "has arrived at " + getName() + id + "airport");
            Map<Integer, Integer> incomingFlights = new HashMap<>();
            for (int i = 0; i < incomingFlights.size(); i++) {
                incomingFlights.put(i, flight.getFlightNumber());
            }
        }
    }

    public void sendPlane(Flight<Passenger> flight) {
        if (LocalTime.now() == flight.getDepartureTime()) {
            LOGGER.debug(flight.getFlightNumber() + "has departed from " + getName() + id + "airport");
            Map<Integer, Integer> outgoingFlights = new HashMap<>();
            for (int i = 0; i < outgoingFlights.size(); i++) {
                outgoingFlights.remove(i, flight.getFlightNumber());
            }
        }
    }

    public String toString() {
        return "Airport id: " + getId() + "\n" +
                "Airport name:" + getName();

    }

    public void printData() {
        String a = toString();
        LOGGER.debug(a);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airport)) return false;
        Airport<?> airport = (Airport<?>) o;
        return Objects.equals(id, airport.id) && Objects.equals(name, airport.name) && Objects.equals(flights, airport.flights) && Objects.equals(airlines, airport.airlines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, flights, airlines);
    }
}
