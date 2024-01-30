/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirlineManagement;

import java.util.Date;
import java.util.ArrayList;
/**
 *
 * @author student
 */
public class Flight {
    String origin, destination;
    Aircraft aircraft;
    ArrayList<Passenger> passengers = new ArrayList<>();
    long departureTime;
    int flightDuration;
    
    public Flight()
    {}
    public Flight(String origin, String destination, Aircraft aircraft, long departureTime, int flightDuration) {
        this.origin = origin;
        this.destination = destination;
        this.aircraft = aircraft;
        this.departureTime = departureTime;
        this.flightDuration = flightDuration;
    }

    public int getOccupiedSeats() {
        return passengers.size();
    }
    public int getRemainingSeats() {
        return aircraft.getMax_seats() - getOccupiedSeats();
    }

    public String getOrigin() {
        return origin;
    }

    public long getDepartureTime() {
        return departureTime;
    }

    public int getFlightDuration() {
        return flightDuration;
    }

    public String getDestination() {
        return destination;
    }
  
}
