package com.kodilla.exception.test;

public class ExceptionModuleRunner {
    public static void main(String[] args) {

        Flight flight1 = new Flight("Cracow", "Berlin");
        Flight flight2 = new Flight("Warsaw", "Oslo");

        FlightFinder flightFinder = new FlightFinder();

        try {
            boolean canFly = flightFinder.findFlight(flight1);
            System.out.println("Flight from: " + flight1.getDepartureAirport()
                    + " to: " + flight1.getArrivalAirport() + " available: " + canFly);

        } catch (RouteNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            boolean canFly = flightFinder.findFlight(flight2);
            System.out.println("Flight from: " + flight2.getDepartureAirport()
                    + " to: " + flight2.getArrivalAirport() + " available: " + canFly);
        } catch (RouteNotFoundException e){
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Program Finished!");
    }
}
