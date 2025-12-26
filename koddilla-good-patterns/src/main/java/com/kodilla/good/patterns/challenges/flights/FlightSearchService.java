package com.kodilla.good.patterns.challenges.flights;

import java.util.List;
import java.util.Set;

public class FlightSearchService {
    private final Set<Flight> flights;

    public FlightSearchService(Set<Flight> flights) {
        this.flights = flights;
    }

    public List<Flight> findFlightFrom(String city) {
        return flights.stream()
                .filter(flight -> flight.getDeparture().equals(city))
                .toList();
    }

    public List<Flight> findFlightTo(String city) {
        return flights.stream()
                .filter(flight -> flight.getDeparture().equals(city))
                .toList();
    }

    public List<List<Flight>> findFlightsWithStop(String from, String to) {

        return flights.stream()
                .filter(firstLeg -> firstLeg.getDeparture().equals(from))
                .flatMap(firstLeg ->
                        flights.stream()
                                .filter(secondLeg ->
                                        secondLeg.getDeparture().equals(firstLeg.getArrival())
                                                && secondLeg.getArrival().equals(to))
                                .map(secondLeg -> List.of(firstLeg, secondLeg)))
                .toList();
    }
}