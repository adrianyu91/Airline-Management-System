package Persistence;

import Helper.AirportInfo;
import Helper.ProvinceInfo;
import Helper.UserInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class province_CRUD {
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
    
    public static ProvinceInfo read(String abbreviation)
    {
        ProvinceInfo province = null;
        try{
            Connection con = getCon();
            String q = "SELECT * FROM provinces WHERE id = '" + abbreviation + "'";
            
            PreparedStatement ps = con.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                province = new ProvinceInfo(rs.getString("name"), rs.getString("id"));
            }
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return province;
    }
}
