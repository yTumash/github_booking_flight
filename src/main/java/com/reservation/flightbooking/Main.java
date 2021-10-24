package com.reservation.flightbooking;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    public static void main(String[] args) throws InvalidNameException {

        final Logger LOGGER = LogManager.getLogger(Main.class);

        LegacyCompany airline1 = new LegacyCompany ("Belavia", LocalDate.of(1993, 10, 9));
        LegacyCompany airline2 = new LegacyCompany ("Turkish Airlines", LocalDate.of(1933, 6, 20));
        LegacyCompany airline3 = new LegacyCompany ("Emirates Airways", LocalDate.of(1985, 3, 25));
        List<AirlineCompany<Flight<Passenger>> > airlines = new ArrayList<>();
        airlines.add(airline1);
        airlines.add(airline2);
        airlines.add(airline3);

        airline1.provideService();
        airline1.allowBaggage();
        airline1.allowCarryOn();
        airline1.serveMeals();

        airline2.provideService();
        airline2.allowBaggage();
        airline2.allowCarryOn();
        airline2.serveMeals();

        airline3.provideService();
        airline3.allowBaggage();
        airline3.allowCarryOn();
        airline3.serveMeals();

        System.out.println(airline1.getName().hashCode());
        System.out.println(airline2.getName().hashCode());
        System.out.println(airline1.getName().equals(airline2.getName()));

        Seat s1 = new Seat();
        Seat s2 = new Seat();
        Seat s3 = new Seat();
        Seat s4 = new Seat();
        Seat s5 = new Seat();
        Seat s6 = new Seat();
        Seat s7 = new Seat();
        Seat s8 = new Seat();
        Seat s9 = new Seat();
        Seat s10 = new Seat();
        Seat s11 = new Seat();
        Seat s12= new Seat();
        Seat s13 = new Seat();
        Seat s14 = new Seat();

        List<Seat> seats1 = new ArrayList<>();
        seats1.add(s1);
        seats1.add(s2);
        seats1.add(s3);
        List<Seat> seats2 = new ArrayList<>();
        seats1.add(s4);
        seats1.add(s5);
        seats1.add(s6);
        List<Seat> seats3 = new ArrayList<>();
        seats1.add(s7);
        seats1.add(s8);
        seats1.add(s9);
        seats1.add(s10);
        List<Seat> seats4 = new ArrayList<>();
        seats1.add(s11);
        seats1.add(s12);
        seats1.add(s13);
        seats1.add(s14);

        Aircraft<Seat> aircraft1 = new Aircraft<>("747", "Boeing", 605);
        Aircraft<Seat> aircraft2 = new Aircraft<>("767", "Boeing", 375);
        Aircraft<Seat> aircraft3 = new Aircraft<>("737", "Boeing", 215);
        Aircraft<Seat> aircraft4 = new Aircraft<>("a380", "Airbus", 853);

        aircraft1.setSeats(seats1);
        aircraft2.setSeats(seats2);
        aircraft3.setSeats(seats3);
        aircraft4.setSeats(seats4);

        List<Aircraft<Seat>> aircrafts = new ArrayList<>();
        aircrafts.add(aircraft1);
        aircrafts.add(aircraft2);
        aircrafts.add(aircraft3);
        aircrafts.add(aircraft4);

        aircraft1.printData();
        System.out.println(aircraft1.getId().hashCode());
        System.out.println(aircraft2.getId().hashCode());
        System.out.println(aircraft1.getId().equals(aircraft2.getId()));

        Airport<AirlineCompany<Flight<Passenger>>> airport1 = new Airport<>("MSQ", "Minsk");
        Airport<AirlineCompany<Flight<Passenger>>> airport2 = new Airport<>("SVO", "Sheremetevo");
        Airport<AirlineCompany<Flight<Passenger>>> airport3 = new Airport<>("DME", "Domodedovo");
        Airport<AirlineCompany<Flight<Passenger>>> airport4 = new Airport<>("AYT", "Antalia");
        Airport<AirlineCompany<Flight<Passenger>>> airport5 = new Airport<>("ICT", "Istanbul");
        Airport<AirlineCompany<Flight<Passenger>>> airport6 = new Airport<>("BCN", "Barcelona");
        Airport<AirlineCompany<Flight<Passenger>>> airport7 = new Airport<>("DXB", "Dubai");
        Airport<AirlineCompany<Flight<Passenger>>> airport8 = new Airport<>("FCO", "Rome");

        try {
            airport1.setId("MSQ");
            airport1.setId("SVO");
            airport1.setId("DME");
            airport1.setId("AYT");
            airport1.setId("ICT");
            airport1.setId("BCN");
            airport1.setId("DXB");
            airport1.setId("FCO");
        } catch (InvalidNameException e) {
            LOGGER.debug("The id should only contain capital letters");
        }

        airport1.setAirlines(airlines);
        airport2.setAirlines(airlines);
        airport3.setAirlines(airlines);
        airport4.setAirlines(airlines);
        airport5.setAirlines(airlines);
        airport6.setAirlines(airlines);
        airport7.setAirlines(airlines);
        airport8.setAirlines(airlines);

        List<Airport<AirlineCompany<Flight<Passenger>>>> airports = new ArrayList<>();

        airports.add(airport1);
        airports.add(airport2);
        airports.add(airport3);
        airports.add(airport4);
        airports.add(airport5);
        airports.add(airport6);
        airports.add(airport7);
        airports.add(airport8);

        airport1.printData();
        airport2.printData();
        airport3.printData();
        airport4.printData();
        airport5.printData();
        airport6.printData();
        airport7.printData();
        airport8.printData();
        System.out.println(airport1.getId().hashCode());
        System.out.println(airport2.getId().hashCode());
        System.out.println(airport1.getId().equals(airport2.getId()));

        Itinerary itinerary1 = new Itinerary();
        Itinerary itinerary2 = new Itinerary();
        Itinerary itinerary3 = new Itinerary();
        Itinerary itinerary4 = new Itinerary();
        Itinerary itinerary5 = new Itinerary();
        Itinerary itinerary6 = new Itinerary();
        Itinerary itinerary7 = new Itinerary();

        itinerary1.setItinerary("Minsk", "Moscow");
        itinerary2.setItinerary("Minsk", "Istanbul");
        itinerary3.setItinerary("Minsk", "Rome");
        itinerary4.setItinerary("Minsk", "Dubai");
        itinerary5.setItinerary("Minsk", "Paris");
        itinerary6.setItinerary("Minsk", "Barcelona");
        itinerary7.setItinerary("Minsk", "Antalia");

        List<Itinerary> itineraries = new ArrayList<>();
        itineraries.add(itinerary1);
        itineraries.add(itinerary2);
        itineraries.add(itinerary3);
        itineraries.add(itinerary4);
        itineraries.add(itinerary5);
        itineraries.add(itinerary6);
        itineraries.add(itinerary7);

        itinerary1.printData();
        itinerary2.printData();
        itinerary3.printData();
        itinerary4.printData();
        itinerary5.printData();
        itinerary6.printData();
        itinerary7.printData();

        System.out.println(itinerary1.hashCode());
        System.out.println(itinerary2.hashCode());
        System.out.println(itinerary1.equals(itinerary2));

        airline1.displayItineraries(itineraries);

        Passenger p1 = new Member("Kate", "MC5436789", 7);
        Passenger p2 = new Member("Alex", "MC7365244", 2);
        Passenger p3 = new NonMember("Peter", "MC5498254", 0);
        Passenger p4 = new NonMember("Kate", "MC9525679", 0);
        Passenger p5 = new Member("Lilly", "MC8934651", 4);
        Passenger p6 = new Member("Mark", "MC9475623", 7);
        Passenger p7 = new NonMember("John", "MC9036145", 0);
        Passenger p8 = new NonMember("Victor", "MC3672061", 0);
        Passenger p9 = new NonMember("Margaret", "MC4893625", 0);
        Passenger p10 = new Member("Sylvia", "MC7015382", 1);
        Passenger p11 = new NonMember("Soo", "MC4962859", 0);

        try {
            p1.setAge(44);
            p2.setAge(36);
            p3.setAge(22);
            p4.setAge(28);
        } catch (InvalidAgeException e) {
            LOGGER.debug("The age has to be positive");
        }

        List<Passenger> passengers1 = new ArrayList<>();
        passengers1.add(p1);
        passengers1.add(p2);
        passengers1.add(p3);
        passengers1.add(p4);
        List<Passenger> passengers2 = new ArrayList<>();
        passengers1.add(p5);
        passengers1.add(p6);
        passengers1.add(p7);
        passengers1.add(p8);
        List<Passenger> passengers3 = new ArrayList<>();
        passengers1.add(p9);
        passengers1.add(p10);
        passengers1.add(p11);

        p1.printData();
        p2.printData();
        p3.printData();
        p4.printData();
        p5.printData();
        p6.printData();
        p7.printData();
        p8.printData();
        p9.printData();

        System.out.println(p1.getPassportNumber().hashCode());
        System.out.println(p2.getPassportNumber().hashCode());
        System.out.println(p1.getPassportNumber().equals(p2.getPassportNumber()));

        Flight<Passenger> flight1 = new Flight<>(LocalDate.of(2021, 10, 15), 89456, LocalTime.of(10, 25), LocalTime.of(12, 25));
        Flight<Passenger> flight2 = new Flight<>(LocalDate.of(2021, 12, 10), 90436, LocalTime.of(15, 45), LocalTime.of(20, 00));
        Flight<Passenger> flight3 = new Flight<>(LocalDate.of(2021, 10, 15), 12456, LocalTime.of(12, 10), LocalTime.of(23, 15));
        Flight<Passenger> flight4 = new Flight<>(LocalDate.of(2021, 10, 15), 98403, LocalTime.of(10, 50), LocalTime.of(17, 20));
        Flight<Passenger> flight5 = new Flight<>(LocalDate.of(2021, 10, 15), 41287, LocalTime.of(19, 30), LocalTime.of(2, 50));
        Flight<Passenger> flight6 = new Flight<>(LocalDate.of(2021, 10, 15), 18521, LocalTime.of(23, 10), LocalTime.of(3, 10));
        Flight<Passenger> flight7 = new Flight<>(LocalDate.of(2021, 10, 15), 71642, LocalTime.of(17, 25), LocalTime.of(21, 45));

        flight1.setItinerary(itinerary1);
        flight2.setItinerary(itinerary2);
        flight3.setItinerary(itinerary6);
        flight4.setItinerary(itinerary3);
        flight5.setItinerary(itinerary5);
        flight6.setItinerary(itinerary7);
        flight7.setItinerary(itinerary4);

        List<Flight<Passenger>> flights1 = new ArrayList<>();
        flights1.add(flight1);
        flights1.add(flight2);
        List<Flight<Passenger>> flights2 = new ArrayList<>();
        flights2.add(flight3);
        flights2.add(flight4);
        flights2.add(flight5);
        List<Flight<Passenger>> flights3 = new ArrayList<>();
        flights3.add(flight6);
        flights3.add(flight7);

        flight1.setPassengers(passengers1);
        flight3.setPassengers(passengers2);
        flight6.setPassengers(passengers3);

        flight1.changeFlight();
        flight2.changeFlight();
        flight3.changeFlight(airport5);
        flight4.changeFlight(airport7);
        flight5.changeFlight(airport7);
        flight6.changeFlight();
        flight7.changeFlight();

        AirlineCompany.createFlight(flight1);
        AirlineCompany.createFlight(flight2);
        AirlineCompany.createFlight(flight3);
        AirlineCompany.createFlight(flight4);
        AirlineCompany.createFlight(flight5);
        AirlineCompany.createFlight(flight6);
        AirlineCompany.createFlight(flight7);

        airline1.setFlights(flights1);
        airline2.setFlights(flights2);
        airline3.setFlights(flights3);

        airport1.setFlight(flights1);
        airport2.setFlight(flights2);
        airport3.setFlight(flights3);

        airline1.displayFlights(flights1);
        airline2.displayFlights(flights2);
        airline3.displayFlights(flights3);

        flight1.setSeatsLeft(aircrafts,10);
        flight2.setSeatsLeft(aircrafts, 34);
        flight3.setSeatsLeft(aircrafts, 0);
        flight4.setSeatsLeft(aircrafts, 100);
        flight5.setSeatsLeft(aircrafts,1);
        flight6.setSeatsLeft(aircrafts,0);
        flight7.setSeatsLeft(aircrafts,2);

        try {
            flight1.setPrice(100.0d);
            flight2.setPrice(120.0d);
            flight3.setPrice(250.0d);
            flight4.setPrice(300.0d);
            flight5.setPrice(350.0d);
            flight6.setPrice(150.0d);
            flight7.setPrice(350.0d);
        } catch (InvalidPriceException e) {
            LOGGER.debug("The price has to be positive");
        }

        flight1.fly();
        flight2.fly();
        flight3.fly();
        flight4.fly();
        flight5.fly();
        flight6.fly();
        flight7.fly();

        Baggage b1 = new CarryOn();
        Baggage b2 = new Luggage();

        try {
            b1.setWeight(10);
            b2.setWeight(30);
        } catch (InvalidCarryOnWeightException e) {
            LOGGER.debug("The weight of carry-on can't be more than 10 kg.");
        } catch (InvalidBaggageWeightException e) {
            LOGGER.debug("The weight of carry-on can't be more than 30 kg.");
        }

        flight1.getLuggage();
        flight1.getCarryOn();
        flight2.getLuggage();
        flight2.getCarryOn();
        flight3.getLuggage();
        flight3.getCarryOn();
        flight4.getLuggage();
        flight4.getCarryOn();
        flight5.getLuggage();
        flight5.getCarryOn();
        flight6.getLuggage();
        flight6.getCarryOn();
        flight7.getLuggage();
        flight7.getCarryOn();

        flight1.printData();
        flight2.printData();
        System.out.println(flight1.getFlightNumber().hashCode());
        System.out.println(flight2.getFlightNumber().hashCode());
        System.out.println(flight1.getFlightNumber().equals(flight2.getFlightNumber()));

        airport1.sendPlane(flight1);
        airport2.receivePlane(flight1);
        airport1.sendPlane(flight2);
        airport5.sendPlane(flight2);
        airport1.sendPlane(flight3);
        airport5.receivePlane(flight3);
        airport5.sendPlane(flight3);
        airport1.sendPlane(flight4);
        airport7.receivePlane(flight4);
        airport7.sendPlane(flight4);
        airport8.receivePlane(flight4);
        airport1.sendPlane(flight5);
        airport7.receivePlane(flight5);
        airport7.sendPlane(flight5);
        airport1.sendPlane(flight6);
        airport5.receivePlane(flight6);
        airport1.sendPlane(flight7);
        airport7.receivePlane(flight7);

        flight1.bookFlight();
        flight3.bookFlight();
        flight7.bookFlight();
        flight4.bookFlight();

        BookingServiceImpl booking1 = new BookingServiceImpl();
        BookingServiceImpl booking2 = new BookingServiceImpl();
        BookingServiceImpl booking3 = new BookingServiceImpl();
        BookingServiceImpl booking4 = new BookingServiceImpl();

        booking1.bookSmth(flight1);
        p1.useDiscount(flight1);
        booking2.bookSmth(flight3);
        p2.useDiscount(flight3);
        booking3.bookSmth(flight7);
        p2.useDiscount(flight7);
        booking4.bookSmth(flight4);
        p2.useDiscount(flight4);

        Ticket t1 = new Ticket();
        Ticket t2 = new Ticket();
        Ticket t3 = new Ticket();
        Ticket t4 = new Ticket();

        t1.printData();
        t2.printData();
        t3.printData();
        t4.printData();;

        try (MyResources resources = new MyResources()) {
            LOGGER.debug("The seat is being booked");
            flight1.bookSeat(89456);
            flight3.bookSeat(12456);
            flight7.bookSeat(71642);
            flight4.bookSeat(98403);
        }
        
        flight1.calculatePrice();
        flight3.calculatePrice();
        flight7.calculatePrice();
        flight4.calculatePrice();
    }
}
