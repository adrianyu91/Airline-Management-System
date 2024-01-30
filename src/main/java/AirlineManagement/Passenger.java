/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirlineManagement;
import java.util.ArrayList;
/**
 *
 * @author student
 */
public class Passenger extends User {
    ArrayList<Flight> flights = new ArrayList<>();
    
    public Passenger(String username, String password, String email, String dob, String firstName, String middleName, String lastName, String citizenship)
    {
        super(username, password, email, dob, firstName, middleName, lastName, citizenship);
    }
    public void addFlight(Flight flight){
        
        flights.add(flight);
        
    }
            
    public ArrayList<Flight> getBookedFlights()
    {
        return flights;
    }
}
