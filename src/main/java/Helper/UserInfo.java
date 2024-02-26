package Helper;

import Persistence.user_CRUD;
import java.util.ArrayList;
import java.util.Date;

public class UserInfo {
    public String nameFirst, nameLast, nameMiddle;
    public String dateofBirth;
    public String citizenship, email, password;
    public boolean isEmployee;
    
    public ArrayList<FlightInfo> bookedFlights = new ArrayList<>();
    public void addFlight(FlightInfo flight){
        bookedFlights.add(flight);
    }
            
    public ArrayList<FlightInfo> getBookedFlights()
    {
        return bookedFlights;
    }

    public UserInfo(String nameFirst, String nameMiddle, String nameLast, String dateofBirth, String citizenship, String email, String password, boolean isEmployee) {
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
        this.nameMiddle = nameMiddle;
        this.dateofBirth = dateofBirth;
        this.citizenship = citizenship;
        this.email = email;
        this.password = password;
        this.isEmployee = isEmployee;
    }
    
    
    
    
}
