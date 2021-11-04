package com.solvd.flightbooking;

import com.solvd.flightbooking.exceptions.*;
import com.solvd.flightbooking.interfaces.Buyable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static <Type> void main(String[] args) throws InvalidNameException {

        final Logger LOGGER = LogManager.getLogger(Main.class);

        LegacyCompany airline1 = new LegacyCompany("Belavia", LocalDate.of(1993, 10, 9));
        LegacyCompany airline2 = new LegacyCompany("Turkish Airlines", LocalDate.of(1933, 6, 20));
        LegacyCompany airline3 = new LegacyCompany("Emirates Airways", LocalDate.of(1985, 3, 25));
        List<AirlineCompany<Flight<Passenger>>> airlines = new ArrayList<>();
        airlines.add(airline1);
        airlines.add(airline2);
        airlines.add(airline3);

        List<AirlineCompany<Flight<Passenger>>> findAirline = airlines.stream()
                .filter(airline -> airline.getDob().isAfter(LocalDate.of(1990, 1, 1)))
                .peek(airline -> airline.getName().startsWith("B"))
                .collect(Collectors.toList());
        findAirline.forEach(airline -> System.out.println(airline.getFlights()));

        airline1.provideService();
        airline1.allowBaggage();
        airline1.allowCarryOn();
        airline1.setFood(LegacyCompany.Food.NORMAL);

        LegacyCompany.Food new1 = LegacyCompany.Food.chooseFood("normal");
        LegacyCompany.Food new2 = LegacyCompany.Food.chooseFood("halal");
        LegacyCompany.Food new3 = LegacyCompany.Food.chooseFood("vegan");
        LegacyCompany.Food new4 = LegacyCompany.Food.chooseFood("vegetarian");

        airline2.provideService();
        airline2.allowBaggage();
        airline2.allowCarryOn();
        airline1.setFood(LegacyCompany.Food.HALAL);

        airline3.provideService();
        airline3.allowBaggage();
        airline3.allowCarryOn();
        airline3.setFood(LegacyCompany.Food.VEGETARIAN);

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
        Seat s12 = new Seat();
        Seat s13 = new Seat();
        Seat s14 = new Seat();

        s1.setType(Seat.Type.ECONOMY);
        s1.setType(Seat.Type.BUSINESS);
        s1.setType(Seat.Type.PREMIUM_ECONOMY);
        s1.setType(Seat.Type.ECONOMY);
        s1.setType(Seat.Type.FIRST_CLASS);
        s1.setType(Seat.Type.ECONOMY);
        s1.setType(Seat.Type.BUSINESS);
        s1.setType(Seat.Type.FIRST_CLASS);
        s1.setType(Seat.Type.ECONOMY);
        s1.setType(Seat.Type.PREMIUM_ECONOMY);
        s1.setType(Seat.Type.PREMIUM_ECONOMY);
        s1.setType(Seat.Type.ECONOMY);
        s1.setType(Seat.Type.ECONOMY);
        s1.setType(Seat.Type.ECONOMY);

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

        Seat.Type takenSeat1 = Seat.Type.takeSeat("economy");
        Seat.Type takenSeat2 = Seat.Type.takeSeat("business");
        Seat.Type takenSeat3 = Seat.Type.takeSeat("premium economy");
        Seat.Type takenSeat4 = Seat.Type.takeSeat("first class");

        Aircraft<Seat> aircraft1 = new Aircraft<>("747", 605);
        Aircraft<Seat> aircraft2 = new Aircraft<>("767", 375);
        Aircraft<Seat> aircraft3 = new Aircraft<>("737", 215);
        Aircraft<Seat> aircraft4 = new Aircraft<>("a380", 853);

        aircraft1.setModel(Aircraft.Model.AIRBUS);
        aircraft1.setModel(Aircraft.Model.AIRBUS);
        aircraft1.setModel(Aircraft.Model.AIRBUS);
        aircraft1.setModel(Aircraft.Model.BOING);

        aircraft1.setSeats(seats1);
        aircraft2.setSeats(seats2);
        aircraft3.setSeats(seats3);
        aircraft4.setSeats(seats4);

        List<Aircraft<Seat>> aircrafts = new ArrayList<>();
        aircrafts.add(aircraft1);
        aircrafts.add(aircraft2);
        aircrafts.add(aircraft3);
        aircrafts.add(aircraft4);

        List<Aircraft<Seat>> seatClass = aircrafts.stream()
                .filter(aircraft -> aircraft.getModel().equals(Aircraft.Model.AIRBUS))
                .filter(aircraft -> aircraft.getCapacity() > 600)
                .peek(aircraft -> aircraft.getSeats().equals(Seat.Type.ECONOMY))
                .collect(Collectors.toList());
        seatClass.forEach(aircraft -> LOGGER.debug(aircraft.getId()));

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

        List<Flight<Passenger>> flightsListed = airlines.stream()
                .filter(airlineCompany -> airlineCompany.getName().contains("B"))
                .flatMap(airlineCompany -> airlineCompany.getFlights().stream())
                .filter(flight -> flight.getItinerary().equals("Moscow"))
                .filter(flight -> flight.getSeatsLeft() > 0)
                .collect(Collectors.toList());
        flightsListed.forEach(flight -> LOGGER.debug(flight.getFlightNumber()));

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

        Passenger p1 = new Member(7);
        Passenger p2 = new Member(2);
        Passenger p3 = new NonMember(0);
        Passenger p4 = new NonMember(0);
        Passenger p5 = new Member(4);
        Passenger p6 = new Member(7);
        Passenger p7 = new NonMember(0);
        Passenger p8 = new NonMember(0);
        Passenger p9 = new NonMember(0);
        Passenger p10 = new Member(1);
        Passenger p11 = new NonMember(0);

        try {
            p1.setName("Kate");
            p2.setName("Alex");
            p3.setName("Peter");
            p4.setName("Kate");
            p5.setName("Lilly");
            p6.setName("Mark");
            p7.setName("John");
            p8.setName("Victor");
            p9.setName("Margaret");
            p10.setName("Sylvia");
            p11.setName("Soo");
        } catch (InvalidHumanNameException e) {
            LOGGER.debug("The name must only contain letter");
        }

        p1.setPassportNumber("MC5436789");
        p2.setPassportNumber("MC7365244");
        p3.setPassportNumber("MC5498254");
        p4.setPassportNumber("MC9525679");
        p5.setPassportNumber("MC8934651");
        p6.setPassportNumber("MC9475623");
        p7.setPassportNumber("MC9036145");
        p8.setPassportNumber("MC3672061");
        p9.setPassportNumber("MC4893625");
        p10.setPassportNumber("MC7015382");
        p11.setPassportNumber("MC4962859");

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

        flight1.setSeatsLeft(aircrafts, 10);
        flight2.setSeatsLeft(aircrafts, 34);
        flight3.setSeatsLeft(aircrafts, 0);
        flight4.setSeatsLeft(aircrafts, 100);
        flight5.setSeatsLeft(aircrafts, 1);
        flight6.setSeatsLeft(aircrafts, 0);
        flight7.setSeatsLeft(aircrafts, 2);

        try {
            switch (takenSeat1) {
                case ECONOMY:
                    flight1.setPrice(100.0d);
                    flight2.setPrice(120.0d);
                    flight3.setPrice(250.0d);
                    flight4.setPrice(300.0d);
                    flight5.setPrice(350.0d);
                    flight6.setPrice(150.0d);
                    flight7.setPrice(350.0d);
                    break;
                case PREMIUM_ECONOMY:
                    flight1.setPrice(200.0d);
                    flight2.setPrice(180.0d);
                    flight3.setPrice(350.0d);
                    flight4.setPrice(500.0d);
                    flight5.setPrice(600.0d);
                    flight6.setPrice(300.0d);
                    flight7.setPrice(550.0d);
                    break;
                case BUSINESS:
                    flight1.setPrice(900.0d);
                    flight2.setPrice(1000.0d);
                    flight3.setPrice(1200.0d);
                    flight4.setPrice(1000.0d);
                    flight5.setPrice(1100.0d);
                    flight6.setPrice(1300.0d);
                    flight7.setPrice(1550.0d);
                    break;
                case FIRST_CLASS:
                    flight1.setPrice(1900.0d);
                    flight2.setPrice(2000.0d);
                    flight3.setPrice(2200.0d);
                    flight4.setPrice(2000.0d);
                    flight5.setPrice(2100.0d);
                    flight6.setPrice(2300.0d);
                    flight7.setPrice(2550.0d);
                    break;
            }
            switch (takenSeat2) {
                case ECONOMY:
                    flight1.setPrice(100.0d);
                    flight2.setPrice(120.0d);
                    flight3.setPrice(250.0d);
                    flight4.setPrice(300.0d);
                    flight5.setPrice(350.0d);
                    flight6.setPrice(150.0d);
                    flight7.setPrice(350.0d);
                    break;
                case PREMIUM_ECONOMY:
                    flight1.setPrice(200.0d);
                    flight2.setPrice(180.0d);
                    flight3.setPrice(350.0d);
                    flight4.setPrice(500.0d);
                    flight5.setPrice(600.0d);
                    flight6.setPrice(300.0d);
                    flight7.setPrice(550.0d);
                    break;
                case BUSINESS:
                    flight1.setPrice(900.0d);
                    flight2.setPrice(1000.0d);
                    flight3.setPrice(1200.0d);
                    flight4.setPrice(1000.0d);
                    flight5.setPrice(1100.0d);
                    flight6.setPrice(1300.0d);
                    flight7.setPrice(1550.0d);
                    break;
                case FIRST_CLASS:
                    flight1.setPrice(1900.0d);
                    flight2.setPrice(2000.0d);
                    flight3.setPrice(2200.0d);
                    flight4.setPrice(2000.0d);
                    flight5.setPrice(2100.0d);
                    flight6.setPrice(2300.0d);
                    flight7.setPrice(2550.0d);
                    break;
            }
            switch (takenSeat3) {
                case ECONOMY:
                    flight1.setPrice(100.0d);
                    flight2.setPrice(120.0d);
                    flight3.setPrice(250.0d);
                    flight4.setPrice(300.0d);
                    flight5.setPrice(350.0d);
                    flight6.setPrice(150.0d);
                    flight7.setPrice(350.0d);
                    break;
                case PREMIUM_ECONOMY:
                    flight1.setPrice(200.0d);
                    flight2.setPrice(180.0d);
                    flight3.setPrice(350.0d);
                    flight4.setPrice(500.0d);
                    flight5.setPrice(600.0d);
                    flight6.setPrice(300.0d);
                    flight7.setPrice(550.0d);
                    break;
                case BUSINESS:
                    flight1.setPrice(900.0d);
                    flight2.setPrice(1000.0d);
                    flight3.setPrice(1200.0d);
                    flight4.setPrice(1000.0d);
                    flight5.setPrice(1100.0d);
                    flight6.setPrice(1300.0d);
                    flight7.setPrice(1550.0d);
                    break;
                case FIRST_CLASS:
                    flight1.setPrice(1900.0d);
                    flight2.setPrice(2000.0d);
                    flight3.setPrice(2200.0d);
                    flight4.setPrice(2000.0d);
                    flight5.setPrice(2100.0d);
                    flight6.setPrice(2300.0d);
                    flight7.setPrice(2550.0d);
                    break;
            }
            switch (takenSeat4) {
                case ECONOMY:
                    flight1.setPrice(100.0d);
                    flight2.setPrice(120.0d);
                    flight3.setPrice(250.0d);
                    flight4.setPrice(300.0d);
                    flight5.setPrice(350.0d);
                    flight6.setPrice(150.0d);
                    flight7.setPrice(350.0d);
                    break;
                case PREMIUM_ECONOMY:
                    flight1.setPrice(200.0d);
                    flight2.setPrice(180.0d);
                    flight3.setPrice(350.0d);
                    flight4.setPrice(500.0d);
                    flight5.setPrice(600.0d);
                    flight6.setPrice(300.0d);
                    flight7.setPrice(550.0d);
                    break;
                case BUSINESS:
                    flight1.setPrice(900.0d);
                    flight2.setPrice(1000.0d);
                    flight3.setPrice(1200.0d);
                    flight4.setPrice(1000.0d);
                    flight5.setPrice(1100.0d);
                    flight6.setPrice(1300.0d);
                    flight7.setPrice(1550.0d);
                    break;
                case FIRST_CLASS:
                    flight1.setPrice(1900.0d);
                    flight2.setPrice(2000.0d);
                    flight3.setPrice(2200.0d);
                    flight4.setPrice(2000.0d);
                    flight5.setPrice(2100.0d);
                    flight6.setPrice(2300.0d);
                    flight7.setPrice(2550.0d);
                    break;
                default:
                    break;
            }
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

        List<Flight> airportList = airports.stream()
                .flatMap(airport -> airport.getFlight().stream())
                .filter(flight -> flight.getDepartureTime().isAfter(LocalTime.of(15, 00)))
                .collect(Collectors.toList());
        LOGGER.debug(airportList);

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
        t4.printData();

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

        List<Passenger> passengerList = passengers1.stream()
                .filter(passenger -> passenger.getPassportNumber().startsWith("MC"))
                .filter(passenger -> passenger.getName().contains("A"))
                .peek(passenger -> passenger.equals(new Member(2)))
                .collect(Collectors.toList());
        LOGGER.debug(passengerList);

        Optional<String> comparison = booking1.compareValue(flight1);
        comparison.filter(value -> (flight1.calculatePrice() - Flight.getPrice()) > 0);
        if (comparison.isPresent()) {
            comparison.get();
        } else if (!comparison.isPresent()) {
            comparison.orElse("0 values to compare");
        } else {
            comparison.orElseThrow(ArithmeticException::new);
        }

        Buyable buyATicket = () -> {
            Double finalPrice = flight1.calculatePrice();
            Double discountedPrice = p1.useDiscount(flight1);
            if (discountedPrice < finalPrice) {
                return discountedPrice;
            }
            return discountedPrice;
        };

        booking1.buy(buyATicket);
        Passenger p30 = new Member(10);

        try {
            Class<?> myPassenger = Class.forName("com.solvd.flightbooking.Member");
            Constructor<?> c = myPassenger.getConstructor(Integer.class);
            Object p22 = c.newInstance(6);
            Method method = myPassenger.getMethod("getPassportNumber");
            LOGGER.debug(method.getName());
            LOGGER.debug("Before: " + p1.getPassportNumber());
            method.invoke(p1, "MC271905764");
            LOGGER.debug("After: " + p1.getPassportNumber());
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
