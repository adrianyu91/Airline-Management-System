<%-- 
    Document   : flightsearch
    Created on : Jan 30, 2024, 11:27:12 AM
    Author     : student
--%>
<%@page import="Helper.UserInfo"%>
<%@page import="Helper.FlightInfo"%>
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
                    ArrayList<FlightInfo> flts = (ArrayList<FlightInfo>)session.getAttribute("flights");
                    UserInfo uinfo = (UserInfo)session.getAttribute("userData");
%>
    <center>
        <h1>Search for Flights</h1>
        <h3><%if(uinfo != null){%>
            Where would you like to go, <%=uinfo.nameFirst%>?
                <%}else{%>Where would you like to go?<%}%></h3>
        <form action="BookFlight" method="post">
            <table border="2" align="center" cellpadding="5" cellspacing="5">
                <tr>
                    <th>Date</th>
                    <th>Origin</th>
                    <th>Destination</th>
                    <th>Time</th>
                    <th>Duration</th>
                    <th>Available Seats</th>
                    <th>Price</th>
                    <%if(uinfo != null){%>
                    <th>Book</th>
                    <%}%>
                </tr> 
                <% for(FlightInfo flight:flts){
                    %>
                    <tr>
                        <td> <%=flight.getDate()%></td>
                        <td> <%=flight.getOrigin()%></td>
                        <td> <%=flight.getDestination()%></td>
                        <td> <%=flight.getDepartureTime()%></td>
                        <td> <%=flight.getFlightDuration()%></td>
                        <td> <%=flight.getRemainingSeats()%></td>
                        <td> <%=String.format("$%.02f", flight.getPrice())%>
                        <%if(uinfo != null){%>
                        <% if(flight.isAvailable()) { %>
                        <td> <input type="hidden" name="flightid" value="<%=flight.getId()%>">
                                    <input type="submit" value="Book Flight"></td>
                        <%}
                        else {%>
                        <td>Unavailable to book</td>
                        
                        <% }%>
                        <%}}%>
                    </tr>
            </table>
        </form>
    </center>
    </body>
</html>
