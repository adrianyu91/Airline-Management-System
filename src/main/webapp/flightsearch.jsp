<%-- 
    Document   : flightsearch
    Created on : Jan 30, 2024, 11:27:12 AM
    Author     : student
--%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="AirlineManagement.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flight Search</title>
    </head>
    <body>
        <% 
    ArrayList<Flight> flightResults = (ArrayList)request.getAttribute("flightResults");
  
%>
    <center>
        <h1>Search for Flights</h1>
        <h3>Where would you like to go, <%=session.getAttribute("fname")%>?</h3>
        <form action=""Extend" method=""post">
            <table border="2" align="center" cellpadding="5" cellspacing="5">
                <tr>
                    <th>Origin</th>
                    <th>Destination</th>
                    <th>Time</th>
                    <th>Duration</th>
                    <th>Available Seats</th>
                </tr> 
                <% for(Flight flight:flightResults){
                    %>
                    <tr>
                        <td> <%=flight.getOrigin()%></td>
                        <td> <%=flight.getDestination()%></td>
                        <td> <%=flight.getDepartureTime()%></td>
                        <td> <%=flight.getFlightDuration()%></td>
                        <td> <%=flight.getRemainingSeats()%></td>
                        <% } %>
                    </tr>
            </table>
        </form>
    </center>
    </body>
</html>
