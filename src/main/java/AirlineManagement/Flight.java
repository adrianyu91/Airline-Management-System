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
    private String origin, destination;
    private Aircraft aircraft;
    private int seatsAvailable;
    private int flightNumber;
    private long departureTime;
    private int flightDuration;
    private int flightStatus;
    private int id;
    private float price;
    
    public Flight()
    {}
    public Flight(int id, int number, String origin, String destination, Aircraft aircraft, long departureTime, int flightDuration) {
        this.id = id;
        this.flightNumber = number;
        this.origin = origin;
        this.destination = destination;
        this.aircraft = aircraft;
        this.departureTime = departureTime;
        this.flightDuration = flightDuration;
        this.seatsAvailable = 3; // for testing
        this.flightStatus = 0;
        this.price = 100;
    }
    public boolean isAvailable(){
        return (getRemainingSeats() > 0);
    }

    public int getId() {
        return id;
    }
    
    public float getPrice()
    {
        return this.price;
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
    // just for testing
    public void bookSeat(){
        this.seatsAvailable -=1;
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

    public String getDepartureTime() {
        return new SimpleDateFormat("HH:mm").format((long)this.departureTime*1000);
    }
    public String getDate(){
        return new SimpleDateFormat("yyyy-MM-dd").format((long)this.departureTime*1000);
    }
    public int getFlightDuration() {
        return this.flightDuration;
    }

    public String getDestination() {
        return this.destination;
    }
  
}

