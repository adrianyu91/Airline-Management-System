/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirlineManagement;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author student
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
            request.setAttribute("bookedFlights", uinfo.getBookedFlights());
            
            RequestDispatcher rd= request.getRequestDispatcher("userhome.jsp");
            rd.forward(request, response);
            
        }
    }
    
    private User getUser(String username, String password)
    {
        //Return sample data
        User u;
        switch (username.toLowerCase()) {
            case "john":
                u = new User("john", "password", "john@emailprovider.ca","1990-01-01","John", "James", "Jenkins", "Canadian");
                break;
            case "jane":
                u = new User("jane", "password", "jane@emailprovider.ca","1991-02-02","Jane", "Juniper", "Jenkins", "Canadian");
                u.addFlight(new Flight(1, "CYYZ", "CYYC", new Aircraft("B737", 150), 1706633079, 240));
                u.addFlight(new Flight(2, "CYHM", "CYPQ", new Aircraft("B777", 300), 1706633132, 37));
                break;
            default:
                u = new User("kelly", "password", "kelly@emailprovider.ca","1992-03-03","Kelly", "Katie", "Jenkins", "Canadian");
                break;
        }
        return u;
    }
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
