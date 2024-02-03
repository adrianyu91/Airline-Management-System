<%-- 
    Document   : userhome
    Created on : Feb 3, 2024, 9:48:32 AM
    Author     : student
--%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="AirlineManagement.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
<%ArrayList<Flight> bookedFlights = (ArrayList)request.getAttribute("bookedFlights");%>
    <center>
        <h3>Welcome, <%=session.getAttribute("fname")%>!</h3>
        <!--<a href="account">Edit user details</a>-->
        <br>
        <a href="FlightSearch">Search Flights</a>
        <br>
        <a href="FlightStatus">Check Flight Status</a>
        <%
            if (bookedFlights.isEmpty()){
        %>
            <h4>Looks like you need a vacation!</h4>
        <%  }
            else {
        %>
        <br>
        <h4>Booked Flights</h4>
            <table border="2" align="center" cellpadding="5" cellspacing="5">
                <tr>
                    <th>Date</th>
                    <th>Time</th>
                    <th>Duration</th>
                    <th>Origin</th>
                    <th>Destination</th>
                    <th>Check-in Status</th>
                </tr> 
                <% for(Flight flight:bookedFlights){
                    %>
                    <tr>
                        <td><%=flight.getDate()%></td>
                        <td><%=flight.getDepartureTime()%></td>
                        <td><%=flight.getFlightDuration()%></td>
                        <td><%=flight.getOrigin()%></td>
                        <td><%=flight.getDestination()%></td>
                        <td>Too early to check-in</td>
                        <% } %>
                    </tr>
            </table>
                    <%}%>
    </center>
    </body>
</html>
