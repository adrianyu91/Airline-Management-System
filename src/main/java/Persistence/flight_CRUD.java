/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Helper.AircraftInfo;
import Helper.AirportInfo;
import Helper.FlightInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author student
 */
public class flight_CRUD {
    private static Connection getCon()
    {
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AMS?autoReconnect=true&useSSL=false", "root", "student");
            System.out.println("Connection established.");
        }catch (Exception e)
        {
            System.out.println(e);
        }
        return con;
    }
    
    public static ArrayList<FlightInfo> searchFlight(String origin, String destination)
    {
        ArrayList<FlightInfo> list = new ArrayList<>();
        try{
            Connection con = getCon();
            String q =String.format("SELECT * FROM flight WHERE origin = '%s' AND destination = '%s'", origin, destination);
            
            PreparedStatement ps = con.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                FlightInfo flight = new FlightInfo(rs.getInt("id"), rs.getInt("duration"), rs.getFloat("ticketprice"), 
                        airport_CRUD.read(rs.getString("origin")), airport_CRUD.read(rs.getString("destination")), rs.getString("departuretime"), aircraft_CRUD.read(rs.getString("aircraftreg")));
                list.add(flight);
            }
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return list;
    }
    public static ArrayList<FlightInfo> readAll()
    {
        ArrayList<FlightInfo> list = new ArrayList<>();
        try{
            Connection con = getCon();
            String q =String.format("SELECT * FROM flight");
            
            PreparedStatement ps = con.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                FlightInfo flight = new FlightInfo(rs.getInt("id"), rs.getInt("duration"), rs.getFloat("ticketprice"), 
                        airport_CRUD.read(rs.getString("origin")), airport_CRUD.read(rs.getString("destination")), rs.getString("departuretime"), aircraft_CRUD.read(rs.getString("aircraftreg")));
                list.add(flight);
            }
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return list;
    }
    
    public static FlightInfo read(int flightnumber)
    {
        FlightInfo flight = null;
        try{
            Connection con = getCon();
            String q = "SELECT * FROM flight WHERE id = " + flightnumber;
            
            PreparedStatement ps = con.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                flight = new FlightInfo(rs.getInt("id"), rs.getInt("duration"), rs.getFloat("ticketprice"), 
                        airport_CRUD.read(rs.getString("origin")), airport_CRUD.read(rs.getString("destination")), rs.getString("departuretime"), aircraft_CRUD.read(rs.getString("aircraftreg")));
            }
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return flight;
    }
}
