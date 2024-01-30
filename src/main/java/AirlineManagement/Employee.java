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
public class Employee extends User{
    boolean isManager;
    
    public Employee(String username, String password, String email, String dob, String firstName, String middleName, String lastName, String citizenship, boolean isManager)
    {
        super(username, password, email, dob, firstName, middleName, lastName, citizenship);
        this.isManager = isManager;
    }
}
