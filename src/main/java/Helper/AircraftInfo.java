/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

/**
 *
 * @author student
 */
public class AircraftInfo {
    public String registration, typecode;
    public int totalSeats;

    public AircraftInfo(String registration, String typecode, int totalSeats) {
        this.registration = registration;
        this.typecode = typecode;
        this.totalSeats = totalSeats;
    }
    
}
