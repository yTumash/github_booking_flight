package com.solvd.flightbooking;

import com.solvd.flightbooking.interfaces.Serviceable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;


public class LowCostCompany extends AirlineCompany<Flight<Passenger>> implements Serviceable {

    private static final Logger LOGGER = LogManager.getLogger(Airport.class);

    public LowCostCompany(String name, LocalDate dob) {
        super(name, dob);
    }

    @Override
    public void provideService() {
        LOGGER.debug("Our company doesn't provide full service on board the plane.");
    }

    @Override
    public void allowBaggage() {
        LOGGER.debug("Our company doesn't allow luggage on board the plane.");
    }

    @Override
    public void allowCarryOn() {
        LOGGER.debug("Our company allows 8 kg carry-on on board the plane.");
    }

    @Override
    public void serveMeals() {
        LOGGER.debug("Our company doesn't provide food on board the plane.");
    }
}
