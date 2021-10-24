package com.reservation.flightbooking;

public class CarryOn extends Baggage {

    @Override
    public String bringBaggage() {
        return "You are allowed a 10 kg carry-on on board the plane.";
    }

    @Override
    public Integer getWeight() {
        return super.getWeight();
    }

    @Override
    public String toString() {
        return "CarryOn: " +
                "Weight: " + weight;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

