package com.reservation.flightbooking;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Objects;

public class Aircraft<Seat> {

    private static final Logger LOGGER = LogManager.getLogger(Aircraft.class);

    private String id;
    private String model;
    private Integer capacity;
    private List<Seat> seats;

    public Aircraft(String id, String model, Integer capacity) {
        this.id = id;
        this.model = model;
        this.capacity = capacity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getCapacity() {

        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = 660;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public void printData() {
        String a = toString();
        LOGGER.debug(a);
    }

    @Override
    public String toString() {
        return "Aircraft information: " + "\n" +
                "id: " + id + "\n" +
                "model: " + model + "\n" +
                "capacity:" + capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aircraft)) return false;
        Aircraft<Seat> aircraft = (Aircraft<Seat>) o;
        return Objects.equals(id, aircraft.id) && Objects.equals(model, aircraft.model) && Objects.equals(capacity, aircraft.capacity) && Objects.equals(seats, aircraft.seats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, capacity, seats);
    }
}
