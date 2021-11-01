package com.solvd.flightbooking;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Flight<Passenger> implements Flyable, Transferable, Bookable {

    private static final Logger LOGGER = LogManager.getLogger(Flight.class);

    private LocalDate date;
    private Integer flightNumber;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private Integer flightCapacity;
    private static Double price;
    private Integer seatsLeft;
    private CarryOn carryOn;
    private Luggage luggage;
    private Itinerary itinerary;
    private List<Passenger> passengers;
    private List<Flight<Passenger>> flights;

    public Flight(LocalDate date, Integer flightNumber, LocalTime departureTime, LocalTime arrivalTime) {
        this.date = date;
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Itinerary getItinerary() {
        return itinerary;
    }

    public void setItinerary(Itinerary itinerary) {
        this.itinerary = itinerary;
    }

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Integer getFlightCapacity() {
        return flightCapacity;
    }

    public void setFlightCapacity(Integer flightCapacity) {
        this.flightCapacity = flightCapacity;
    }

    public static Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        if (price < 0) {
            throw new InvalidPriceException("The price has to be positive");
        } else {
            this.price = price;
        }
    }

    public Integer getSeatsLeft() {
        return seatsLeft;
    }

    public void setSeatsLeft(Integer seatsLeft) {
        this.seatsLeft = seatsLeft;
    }

    public void setSeatsLeft(List<Aircraft<Seat>> planes, Integer seatsLeft) {
        List<String> flightToBook = planes.stream()
                .filter(aircraft -> aircraft.getCapacity() < seatsLeft)
                .map(aircraft -> aircraft.getId())
                .collect(Collectors.toList());
    }

    public String getCarryOn() {
        return carryOn.bringBaggage();
    }

    public void setCarryOn(CarryOn carryOn) {
        if (carryOn.weight > 10) {
            throw new InvalidCarryOnWeightException("The weight of carry-on can't be more than 10 kg.");
        }
        this.carryOn = carryOn;
    }

    public String getLuggage() {
        return luggage.bringBaggage();
    }

    public void setLuggage(Luggage luggage) {
        if (luggage.weight > 30) {
            throw new InvalidBaggageWeightException("The weight of carry-on can't be more than 30 kg.");
        }
        this.luggage = luggage;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public List<Flight<Passenger>> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight<Passenger>> flights) {
        this.flights = flights;
    }

    public void fly() {
    }

    @Override
    public void flyFrom(Airport airport) {
        LOGGER.debug("Flight " + flightNumber + "departs from" + airport.getId());
    }

    @Override
    public void flyTo(Airport airport) {
        LOGGER.debug("Flight " + flightNumber + "arrives at" + airport.getId());
    }

    @Override
    public void changeFlight(Airport airport) {
        LOGGER.debug(flightNumber + "has a transfer at" + airport.getId());
    }

    @Override
    public void changeFlight() {
        LOGGER.debug(flightNumber + "has no transfers.");
    }

    public void bookFlight() {
    }

    public void bookSeat(Integer flightNum) {
        flights.stream()
                .filter(flight -> flight.getFlightNumber().equals(flightNum))
                .map(flight -> flight.getSeatsLeft() -1);
    }

    public static Double calculatePrice() {
        Double price = getPrice();
        if (com.solvd.flightbooking.Passenger.getAge() < 2) {
            price = 0.0d;
            return price;
        } else if (com.solvd.flightbooking.Passenger.getAge() > 65) {
            price = price * 0.10d;
            return price;
        } else {
            LOGGER.debug("There is no discount available for your passenger status.");
        }
        return price;
    }

    public String toString(Itinerary itinerary) {
        return "FlightNumber: " + getFlightNumber() + "\n" +
                "Departs from: " + Itinerary.getOrig() + "\n" +
                "Arrives at: " + Itinerary.getDest() + "\n" +
                "Departure time: " + getDepartureTime() + "\n" +
                "Initial price: " + getPrice() + "\n" +
                "Baggage allowance: " + getLuggage() + "\n" +
                "Carry-On allowance: " + getCarryOn();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight<?> flight = (Flight<?>) o;
        return Objects.equals(date, flight.date) && Objects.equals(flightNumber, flight.flightNumber) && Objects.equals(departureTime, flight.departureTime) && Objects.equals(arrivalTime, flight.arrivalTime) && Objects.equals(flightCapacity, flight.flightCapacity) && Objects.equals(price, flight.price) && Objects.equals(seatsLeft, flight.seatsLeft) && Objects.equals(carryOn, flight.carryOn) && Objects.equals(luggage, flight.luggage) && Objects.equals(itinerary, flight.itinerary) && Objects.equals(passengers, flight.passengers) && Objects.equals(flights, flight.flights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, flightNumber, departureTime, arrivalTime, flightCapacity, price, seatsLeft, carryOn, luggage, itinerary, passengers, flights);
    }
}
