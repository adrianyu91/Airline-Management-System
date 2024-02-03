/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirlineManagement;

import java.text.SimpleDateFormat;
/**
 *
 * @author student
 */
public class Flight {
    String origin, destination;
    Aircraft aircraft;
    int seatsAvailable;
    int flightNumber;
    long departureTime;
    int flightDuration;
    int flightStatus;
    
    public Flight()
    {}
    public Flight(int number, String origin, String destination, Aircraft aircraft, long departureTime, int flightDuration) {
        this.flightNumber = number;
        this.origin = origin;
        this.destination = destination;
        this.aircraft = aircraft;
        this.departureTime = departureTime;
        this.flightDuration = flightDuration;
    }

    public int getOccupiedSeats() {
        return aircraft.max_seats - this.seatsAvailable;
    }
    public int getRemainingSeats() {
        return this.seatsAvailable;
    }

    public int getFlightStatus() {
        return flightStatus;
    }
    
    public String getFlightStatusString()
    {
        switch (this.flightStatus)
        {
            case 0:
                return "On Time";
            case 1:
                return "Delayed";
            case 2:
                return "Cancelled";
            default:
                return "Error!";
        }
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }
    
    public void setFlightStatus(int flightStatus) {
        this.flightStatus = flightStatus;
    }

    
    public String getOrigin() {
        return this.origin;
    }

    public long getDepartureTime() {
        return this.departureTime;
    }
    public String getDate(){
        return new SimpleDateFormat("yyyy-MM-dd").format((long)this.departureTime);
    }
    public int getFlightDuration() {
        return this.flightDuration;
    }

    public String getDestination() {
        return this.destination;
    }
  
}

