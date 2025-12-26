package com.kodilla.good.patterns.challenges.flights;

import java.util.HashSet;
import java.util.Set;

public class FlightRepository {

    private final Set<Flight> flights = new HashSet<>();

    public FlightRepository(){
        flights.add(new Flight("Gdańsk", "Wrocław"));
        flights.add(new Flight("Gdańsk", "Kraków"));
        flights.add(new Flight("Gdańsk", "Warszawa"));
        flights.add(new Flight("Gdańsk", "Katowice"));
        flights.add(new Flight("Warszawa", "Wrocław"));
        flights.add(new Flight("Katowice", "Wrocław"));
        flights.add(new Flight("Kraków", "Wrocław"));
        flights.add(new Flight("Wrocław", "Poznań"));
        flights.add(new Flight("Poznań", "Gdańsk"));
    }
    public Set<Flight> getFlights() {
        return flights;
    }
}
