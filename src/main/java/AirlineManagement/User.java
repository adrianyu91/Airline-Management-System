package AirlineManagement;

import java.util.ArrayList;
import java.util.HashMap;

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
    
    ArrayList<Flight> bookedFlights = new ArrayList<>();
    public void addFlight(Flight flight){
        
        bookedFlights.add(flight);
        
    }
            
    public ArrayList<Flight> getBookedFlights()
    {
        return bookedFlights;
    }
}
