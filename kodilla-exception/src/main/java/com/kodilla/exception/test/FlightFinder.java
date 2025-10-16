package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {
    public boolean findFlight(Flight flight) throws RouteNotFoundException{
        Map<String, Boolean> airports = new HashMap<>();

        airports.put("Warsaw", true);
        airports.put("Berlin", true);
        airports.put("Madrit", false);
        airports.put("Paris", true);

        String arrival = flight.getArrivalAirport();

        if(!airports.containsKey(arrival)){
            throw new RouteNotFoundException("Airport " + arrival + " not found in the system.");
        }

        return airports.get(arrival);
    }
}
