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
public class User {
    String username, password, email, dob, firstName, middleName, lastName, citizenship;

    public User(String username, String password, String email, String dob, String firstName, String middleName, String lastName, String citizenship) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.dob = dob;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.citizenship = citizenship;
    }
    
    ArrayList<Flight> flights = new ArrayList<>();

    public void addFlight(Flight flight){
        
        flights.add(flight);
        
    }
            
    public ArrayList<Flight> getBookedFlights()
    {
        return flights;
    }
}
