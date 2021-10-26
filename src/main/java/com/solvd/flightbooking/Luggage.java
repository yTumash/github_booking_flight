package com.solvd.flightbooking;

public class Luggage extends Baggage {

    @Override
    public String bringBaggage() {
        return "You are allowed a 30 kg checked in luggage.";
    }
}
