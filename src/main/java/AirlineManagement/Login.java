package AirlineManagement;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username=(String) request.getParameter("username");
        String password=(String) request.getParameter("password");
        
        User uinfo=getUser(username, password);
        
        if (uinfo == null){
            RequestDispatcher rd= request.getRequestDispatcher("loginfailed.jsp");
            rd.forward(request, response);
        }
        else{
            request.getSession().setAttribute("fname", uinfo.firstName);
            request.getSession().setAttribute("isLoggedin", true);
            request.setAttribute("bookedFlights", uinfo.getBookedFlights());
            
            RequestDispatcher rd= request.getRequestDispatcher("userhome.jsp");
            rd.forward(request, response);
            
        }
    }
    
    private User getUser(String username, String password)
    {
        FlightsPrototype flts = FlightsPrototype.getInstance();
        
        //Return sample data
        User u;
        switch (username.toLowerCase()) {
            case "john":
                u = new User("john", "password", "john@emailprovider.ca","1990-01-01","John", "James", "Jenkins", "Canadian");
                break;
            case "jane":
                u = new User("jane", "password", "jane@emailprovider.ca","1991-02-02","Jane", "Juniper", "Jenkins", "Canadian");
                u.addFlight(flts.getFlights().get(0));
                u.addFlight(flts.getFlights().get(1));
                break;
            default:
                u = new User("kelly", "password", "kelly@emailprovider.ca","1992-03-03","Kelly", "Katie", "Jenkins", "Canadian");
                break;
        }
        return u;
    }

}
