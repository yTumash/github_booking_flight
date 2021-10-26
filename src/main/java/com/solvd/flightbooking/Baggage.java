package com.solvd.flightbooking;

import java.util.Objects;

public abstract class Baggage {

    public Integer weight;

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public abstract String bringBaggage();

    @Override
    public String toString() {
        return "Baggage: " +
                "Weight: " + weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Baggage)) return false;
        Baggage baggage = (Baggage) o;
        return Objects.equals(weight, baggage.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight);
    }
}
