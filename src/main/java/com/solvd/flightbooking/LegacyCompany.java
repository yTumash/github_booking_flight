package com.solvd.flightbooking;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;


public class LegacyCompany extends AirlineCompany<Flight<Passenger>> implements Serviceable {

    private static final Logger LOGGER = LogManager.getLogger(Airport.class);
    private Food food;

    public LegacyCompany(String name, LocalDate dob) {
        super(name, dob);
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
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

    public enum Food {
        NORMAL("normal"),
        HALAL("halal"),
        VEGAN("vegan"),
        VEGETARIAN("vegetarian");

        private String meal;

        Food(String meal) {
            this.meal = meal;
        }

        public static Food chooseFood(String meal) {
            for (Food food : Food.values()) {
                if (food.getMeal().equals(meal)) {
                    switch (food) {
                        case NORMAL:
                            LOGGER.debug("You are to be served normal meals.");
                            break;
                        case HALAL:
                            LOGGER.debug("You are to be served halal meals.");
                            break;
                        case VEGAN:
                            LOGGER.debug("You are to be served vegan meals.");
                            break;
                        case VEGETARIAN:
                            LOGGER.debug("You are to be served vegetarian meals.");
                            break;
                    }
                }
            }
            return null;
        }

        public String getMeal() {
            return meal;
        }

        public void setMeal(String meal) {
            this.meal = meal;
        }
    }

}
