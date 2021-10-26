package com.solvd.flightbooking;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;


public class LegacyCompany extends AirlineCompany<Flight<Passenger>>  implements Serviceable {

    private static final Logger LOGGER = LogManager.getLogger(Airport.class);

    public LegacyCompany(String name, LocalDate dob) {
        super(name, dob);
    }

    @Override
    public void provideService() {
        LOGGER.debug("Our company provides full service on board the plane.");
    }

    @Override
    public void allowBaggage() {
        LOGGER.debug("Our company allows 30 kg of checked luggage on board the plane.");
    }

    @Override
    public void allowCarryOn() {
        LOGGER.debug("Our company allows 10 kg checked carry-on on board the plane.");
    }

    @Override
    public void serveMeals() {
        LOGGER.debug("Our company provides a varied menu on board the plane.");
    }

}
