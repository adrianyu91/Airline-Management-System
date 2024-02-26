package Persistence;

import Helper.AirportInfo;
import Helper.UserInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class airport_CRUD {
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
    
    public static AirportInfo read(String icao)
    {
        AirportInfo bean = null;
        try{
            Connection con = getCon();
            String q = "SELECT * FROM airport WHERE icao = '" + icao + "'";
            
            PreparedStatement ps = con.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                bean = new AirportInfo(rs.getString("icao"), rs.getString("name"), rs.getString("city"), province_CRUD.read(rs.getString("province")));
                
            }
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return bean;
    }
}
