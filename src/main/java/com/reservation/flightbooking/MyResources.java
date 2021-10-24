package com.reservation.flightbooking;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyResources implements AutoCloseable {

    private static final Logger LOGGER = LogManager.getLogger(MyResources.class);

    @Override
    public void close() {
        LOGGER.debug("The flight and the seat have been successfully booked.");
    }

}
