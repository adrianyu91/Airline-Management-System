package Persistence;
import Helper.UserInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class user_CRUD {
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
    
    public static boolean userExisits(String useremail)
    {
        try{
            Connection con = getCon();
            String q = "SELECT * FROM useraccount WHERE email = '" + useremail+"'";
            
            PreparedStatement ps = con.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                String email = rs.getString("email");
                System.out.println("email: "+email+"uem: "+useremail);
                if (email.equals(useremail))
                    return true;
            }
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
    
    public static boolean create(UserInfo user)
    {
        boolean result = false;
        try{
            Connection con = getCon();
            String q = String.format("INSERT INTO useraccount (nameFirst, namemiddle,"
                    + " namelast, dob, citizenship, email, password, isemployee)"
                    + "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', false)", 
                    user.nameFirst, user.nameMiddle, user.nameLast, user.dateofBirth, user.citizenship, user.email, user.password);
            
            PreparedStatement ps = con.prepareStatement(q);
            result = ps.execute();
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return result;
    }
    
    public static UserInfo read(String useremail, String password)
    {
        UserInfo bean = null;
        try{
            Connection con = getCon();
            String q = "SELECT * FROM useraccount WHERE email = '" + useremail+"'";
            
            PreparedStatement ps = con.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                String fname = rs.getString("namefirst");
                String lname = rs.getString("namelast");
                String mname = rs.getString("namemiddle");
                String dateofbirth = rs.getString("dob");
                String citizenship = rs.getString("Citizenship");
                String email = rs.getString("email");
                String pass = rs.getString("password");
                boolean isemployee = rs.getBoolean("isemployee");
                if (pass.equals(password))
                    bean = new UserInfo(fname, mname, lname, dateofbirth, citizenship, email, password, isemployee);
            }
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return bean;
    }
    
    
}
