package AirlineManagement;


public class Employee extends User{
    boolean isManager;
    
    public Employee(String username, String password, String email, String dob, String firstName, String middleName, String lastName, String citizenship, boolean isManager)
    {
        super(username, password, email, dob, firstName, middleName, lastName, citizenship);
        this.isManager = isManager;
    }
}
