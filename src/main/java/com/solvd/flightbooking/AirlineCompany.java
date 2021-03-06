package com.solvd.flightbooking;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AirlineCompany<Flight> {

    private static final Logger LOGGER = LogManager.getLogger(AirlineCompany.class);

    private String name;
    private LocalDate dob;
    private List<Flight> flights;

    public AirlineCompany(String name, LocalDate dob) {
        this.name = name;
        this.dob = dob;
    }

    public static void createFlight(com.solvd.flightbooking.Flight<Passenger> flight) {

        LOGGER.debug(flight.getFlightNumber() + "has been created");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public void displayItineraries(List<Itinerary> itineraries) {
        List<Itinerary> destinationList = itineraries.stream()
                .filter(itinerary -> Itinerary.getOrig() == "Minsk")
                .filter(itinerary -> Itinerary.getDest() != null)
                .collect(Collectors.toList());
        destinationList.forEach(itinerary -> LOGGER.debug(Itinerary.getDest()));
    }

    public void displayFlights(List<Flight> flights) {
        List<Flight> flightsListed = flights.stream()
                .filter(flight -> Itinerary.getOrig() == "Minsk")
                .filter(flight -> Itinerary.getOrig() != null)
                .collect(Collectors.toList());
        LOGGER.debug(flightsListed);
    }

    public void provideService() {
        LOGGER.debug("Our company is oriented at different market segments and provides different kinds of services.");
    }

    @Override
    public String toString() {
        return "Airline name:" + getName() + "\n" +
                "Airline establishmentYear: " + getDob();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AirlineCompany)) return false;
        AirlineCompany<?> that = (AirlineCompany<?>) o;
        return Objects.equals(name, that.name) && Objects.equals(dob, that.dob) && Objects.equals(flights, that.flights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dob, flights);
    }
}




