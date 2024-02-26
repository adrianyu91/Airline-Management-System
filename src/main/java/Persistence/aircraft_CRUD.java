package Persistence;

import Helper.AircraftInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class aircraft_CRUD {
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
    
    public static AircraftInfo read(String registration)
    {
        AircraftInfo bean = null;
        try{
            Connection con = getCon();
            String q = "SELECT * FROM aircraft WHERE registration = '" + registration + "'";
            
            PreparedStatement ps = con.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                bean = new AircraftInfo(rs.getString("registration"), rs.getString("typecode"), rs.getInt("seats"));
                
            }
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return bean;
    }
}
