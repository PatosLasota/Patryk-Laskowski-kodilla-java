package com.kodilla.good.patterns.challenges.flights;

import java.security.Provider;
import java.util.List;

public class App {
    public static void main(String[] args) {
        FlightRepository repository = new FlightRepository();
        FlightSearchService service = new FlightSearchService(repository.getFlights());

        System.out.println("\nLoty z Gdańska: \n");
        service.findFlightFrom("Gdańsk")
                .forEach(System.out::println);

        System.out.println("\nLoty do Wrocławia: \n");
        service.findFlightTo("Wrocław")
                .forEach(System.out::println);

        System.out.println("\nLoty z przesiadką Gdańsk -> Wrocław: \n");
        List<List<Flight>> connections =
                service.findFlightsWithStop("Gdańsk", "Wrocław");

        for (List<Flight> connection : connections) {
            connection.forEach(f -> System.out.print(f + "   "));
            System.out.println();
        }
    }
}
