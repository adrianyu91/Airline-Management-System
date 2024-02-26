<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="AirlineManagement.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flight Status</title>
    </head>
    <body>
        <% 
            FlightsPrototype flts = FlightsPrototype.getInstance();
%>
    <center>
        <h1>Flight Status</h1>
        <form action=Extend" method=post">
            <table border="2" align="center" cellpadding="5" cellspacing="5">
                <tr>
                    <th>Date</th>
                    <th>Time</th>
                    <th>Flight #</th>
                    <th>Duration</th>
                    <th>Origin</th>
                    <th>Destination</th>
                    <th>Status</th>
                </tr> 
                <% for(Flight flight:flts.getFlights()){
                    %>
                    <tr>
                        <td><%=flight.getDate()%></td>
                        <td><%=flight.getDepartureTime()%></td>
                        <td><%=flight.getFlightNumber()%></td>
                        <td><%=flight.getFlightDuration()%></td>
                        <td><%=flight.getOrigin()%></td>
                        <td><%=flight.getDestination()%></td>
                        <td><%=flight.getFlightStatusString()%></td>
                        <% } %>
                    </tr>
            </table>
        </form>
    </center>
    </body>
</html>