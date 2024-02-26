/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Helper.UserInfo;
import Persistence.user_CRUD;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author student
 */
public class CreateUser extends HttpServlet {

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
            out.println("<title>Servlet CreateUser</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateUser at " + request.getContextPath() + "</h1>");
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
        
        String useremail=(String) request.getParameter("email");
        String password=(String) request.getParameter("password");
        String dob=(String) request.getParameter("dob");
        String nameFirst=(String) request.getParameter("firstName");
        String nameMiddle=(String) request.getParameter("middleName");
        String nameLast=(String) request.getParameter("lastName");
        String citizenship=(String) request.getParameter("citizenship");
        
        
        if (user_CRUD.userExisits(useremail))
        {
            System.out.println("User exists!");
            RequestDispatcher rd= request.getRequestDispatcher("accountExists.html");
            rd.forward(request, response);
        }
        else
        {
            System.out.println("New user!");
            UserInfo user = new UserInfo(nameFirst, nameMiddle, nameLast, dob, citizenship, useremail, password, true);
            user_CRUD.create(user);
            request.getSession().setAttribute("userData", user);

            RequestDispatcher rd= request.getRequestDispatcher("userhome.jsp");
            rd.forward(request, response);
        }

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
