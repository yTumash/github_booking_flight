package com.solvd.flightbooking;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Objects;

public class Aircraft<Seat> {

    private static final Logger LOGGER = LogManager.getLogger(Aircraft.class);

    private String id;
    private Model model;
    private Integer capacity;
    private List<Seat> seats;

    public Aircraft(String id, Integer capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public enum Model {
        AIRBUS("airbus"), BOING("boing");

        private String name;

        Model(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
