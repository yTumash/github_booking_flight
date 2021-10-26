package com.solvd.flightbooking;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public abstract class Passenger {

    private static final Logger LOGGER = LogManager.getLogger(Aircraft.class);

    private static Integer age;
    private String name;
    private String passportNumber;

    public static Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        if (age < 0) {
            throw new InvalidAgeException("The age has to be positive");
        }
        Passenger.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidHumanNameException {
        char c;
        for (int i = 0; i < name.length(); i++) {
            c = name.charAt(i);
            if (Character.isDigit(c)){
                throw new InvalidHumanNameException("The name must only contain letters");
            }
            this.name = name;
        }
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public abstract Double useDiscount(Flight<Passenger> flight);

    @Override
    public String toString() {
        return "Name: " + getName() + "\n" +
                "Passport number: " + getPassportNumber() + "\n" +
                "Age: " + getAge() + "\n";
    }

    public void printData() {
        String a = toString();
        LOGGER.debug(a);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passenger)) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(name, passenger.name) && Objects.equals(passportNumber, passenger.passportNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passportNumber);
    }
}
