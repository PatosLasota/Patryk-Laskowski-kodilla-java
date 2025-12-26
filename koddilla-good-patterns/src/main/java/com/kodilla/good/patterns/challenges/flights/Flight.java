package com.kodilla.good.patterns.challenges.flights;

import java.util.Objects;

public class Flight {
    private final String departure;
    private final String arrival;

    public Flight(String departure, String arrival) {
        this.departure = departure;
        this.arrival = arrival;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight flight = (Flight) o;
        return departure.equals(flight.departure)
                && arrival.equals(flight.arrival);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departure, arrival);
    }

    @Override
    public String toString() {
        return departure + " -> " + arrival;
    }
}
