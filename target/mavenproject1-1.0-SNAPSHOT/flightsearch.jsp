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
            FlightsPrototype flts = FlightsPrototype.getInstance();
%>
    <center>
        <h1>Search for Flights</h1>
        <h3><%if(session.getAttribute("isLoggedin") != null){%>
            Where would you like to go, <%=session.getAttribute("fname")%>?
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
                    <%if(session.getAttribute("isLoggedin") != null){%>
                    <th>Book</th>
                    <%}%>
                </tr> 
                <% for(Flight flight:flts.getFlights()){
                    %>
                    <tr>
                        <td> <%=flight.getDate()%></td>
                        <td> <%=flight.getOrigin()%></td>
                        <td> <%=flight.getDestination()%></td>
                        <td> <%=flight.getDepartureTime()%></td>
                        <td> <%=flight.getFlightDuration()%></td>
                        <td> <%=flight.getRemainingSeats()%></td>
                        <td> <%=String.format("$%.02f", flight.getPrice())%>
                        <%if(session.getAttribute("isLoggedin") != null){%>
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
