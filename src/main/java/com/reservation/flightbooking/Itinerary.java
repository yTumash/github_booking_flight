package com.reservation.flightbooking;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Itinerary extends MyResources {

    private static final Logger LOGGER = LogManager.getLogger(Itinerary.class);

    private static String orig;
    private static String dest;

    public static String getOrig() {
        return orig;
    }

    public void setOrig(String orig) {
        Itinerary.orig = orig;
    }

    public static String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        Itinerary.dest = dest;
    }

    public void setItinerary(String orig, String dest) {
        if (!dest.equals(orig)) {
            Itinerary.orig = orig;
            Itinerary.dest = dest;
        } else {
            LOGGER.debug("Please, check your itinerary. There seems to be an input error.");
        }
    }

    @Override
    public void close() {
        super.close();
    }

    @Override
    public String toString() {
        return "Origin: " + getOrig() + "\n" +
                "Destination: " + getDest() + "\n";
    }

    public void printData() {
        String a = toString();
        LOGGER.debug(a);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Itinerary)) return false;
        Itinerary itinerary = (Itinerary) o;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orig, dest);
    }
}
