/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirlineManagement;

/**
 *
 * @author student
 */
public class Aircraft {
    String aircraftType;
    int max_seats;

    public String getAircraftType() {
        return aircraftType;
    }

    public int getMax_seats() {
        return max_seats;
    }

    public Aircraft() {

    }
    public Aircraft(String aircraftType, int max_seats) {
        this.aircraftType = aircraftType;
        this.max_seats = max_seats;
    }

    
}
